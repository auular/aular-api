package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import teste.aular.application.PartnerCampaignTxtFileService;
import teste.aular.application.PartnerCvsFileService;
import teste.aular.domain.contract.CampaignRepository;
import teste.aular.domain.contract.PartnerRepository;
import teste.aular.domain.entity.Campaign;
import teste.aular.domain.entity.Partner;
import teste.aular.utils.ListObj;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/partners")
public class PartnerController {
    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private CampaignRepository campaignRepository;

    @PostMapping
    public ResponseEntity<Partner> addPartner(@RequestBody @Valid Partner partner) {
        if (partner != null) {
            if (!partnerRepository.existsByDocumentId(partner.getDocumentId())) {
                partnerRepository.save(partner);
                return ResponseEntity.status(201).body(partner);
            }
        }
        return ResponseEntity.status(403).build();
    }

    @GetMapping
    public ResponseEntity<List<Partner>> getPartner() {
        List<Partner> list = partnerRepository.findAll();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
    }

    @GetMapping("/orderedPartner")
    public ResponseEntity<?> getOrderedPartner() {
        List<Partner> list = partnerRepository.findAll();
        ListObj<Partner> orderedList = new ListObj(list.size());

        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                orderedList.add(list.get(i));
            }
            int indMenor;

            for (int i = 0; i < orderedList.getSize(); i++) {
                indMenor = i;
                for (int j = i + 1; j < orderedList.getSize(); j++) {
                    if (orderedList.getElement(j).getNumberOfCampaigns() < orderedList.getElement(indMenor).getNumberOfCampaigns()) {
                        indMenor = j;
                    }
                }
                Partner aux = orderedList.getElement(i);
                orderedList.setElement(i, orderedList.getElement(indMenor));
                orderedList.setElement(indMenor, aux);
                System.out.println(orderedList.getElement(i));
            }
            return ResponseEntity.status(200).body(orderedList);
        }
        return ResponseEntity.status(204).build();
    }


    @PatchMapping("/{id}/{email}/{fidelity}")
    public ResponseEntity<Partner> updatePartnerPartially(
            @PathVariable Integer id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) Boolean fidelity,
            @RequestParam(required = false) String phoneNumber) {
        try {
            Partner partner = partnerRepository.findById(id).get();
            if (email != null) {
                partner.setEmail(email);
            }
            if (fidelity != null) {
                partner.setFidelity(fidelity);
            }
            if (phoneNumber != null) {
                partner.setPhoneNumber(phoneNumber);
            }
            return new ResponseEntity<Partner>(partnerRepository.save(partner), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Método para atualizar com DTO incompleto
//    @PutMapping("/{id}")
//    public ResponseEntity<UpdatePartner> put(
//            @PathVariable int id, @RequestBody UpdatePartner updatedPartner) {
//        if (partnerRepository.existsById(id)) {
//            updatedPartner.setPartnerId(id);
//            partnerRepository.save(Partner); // faz um "update" pois o id existe
//            return ResponseEntity.status(200).body(updatedPartner);
//        }
//        return ResponseEntity.status(404).build();
//    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Partner> deactivatePartner(
            @PathVariable Integer id
    ) {
        if (partnerRepository.existsById(id)) {
            Partner pa = partnerRepository.findById(id).get();
            pa.setActive(false);
            pa.setDeactivatedAt(LocalDateTime.now());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/cvsGenerator")
    public ResponseEntity<List<Partner>> getListObj() {
        ListObj<Partner> partnerListObj = new ListObj<>(partnerRepository.findAll().size());

        for (Partner p : partnerRepository.findAll()) {
            partnerListObj.add(p);
        }

        PartnerCvsFileService.PartnerCsvGenerate(partnerListObj, "partnerFile");

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/autentication")
    public ResponseEntity<Partner> logIn(@RequestBody Partner login) throws HttpClientErrorException {

        List<Partner> registeredPartners = partnerRepository.findAll();

        if (registeredPartners.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        for (Partner p : registeredPartners) {
            if (p.authenticatePartner(login.getEmail(), login.seePassword())) {
                p.setAuthenticated(true);
                partnerRepository.save(p);
                return ResponseEntity.status(200).body(p);
            }
        }
        return ResponseEntity.status(401).build();
    }

    @DeleteMapping("autentication/{id}")
    public ResponseEntity<String> logOff(@PathVariable Integer id) {
        try {
            if (partnerRepository.existsById(id)) {
                Partner h = partnerRepository.findById(id).get();
                h.setAuthenticated(false);
                partnerRepository.save(h);
                return ResponseEntity.status(200).build();
            }
            return ResponseEntity.status(404).build();

        } catch (HttpClientErrorException.NotFound e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping(value = "/report/{partnerId}", consumes = "text/plain")
    public ResponseEntity<Void> patchReport(@PathVariable int partnerId, @RequestBody byte[] novoRelatorio) {
        if (!partnerRepository.existsById(partnerId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Partner não encontrado"
            );
        } else {
            if (novoRelatorio.length < 10 || novoRelatorio.length > 10 * 1024 * 1024) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Relatório deve conter entre 10b e 10Mb"
                );
            }
            String conteudoTexto = new String(novoRelatorio);
            partnerRepository.setRelatorio(partnerId, novoRelatorio);
        }
        return ResponseEntity.status(200).build();
    }

    @GetMapping(value = "/report/{partnerId}", produces = "text/plain")
    public ResponseEntity<byte[]> getReport(@PathVariable int partnerId) {
        if (!partnerRepository.existsById(partnerId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Partner não encontrado"
            );
        }
        Partner partner = partnerRepository.findById(partnerId).get();
        String nomeArquivo = partner.getName().replace(" ", "-") + "-Capaigns.txt";

        byte[] relatorio = partnerRepository.getRelatorio(partnerId);
        // esse header "content-disposition" indica o nome do arquivo em caso de download em navegador
//        return ResponseEntity.status(200).header("content-disposition", "attachment; filename=\"relatorio-teste.txt\"").body(relatorio);
        return ResponseEntity.status(200).header("content-disposition", "attachment; filename=" + nomeArquivo).body(relatorio);
    }

    @PostMapping("/reportGenerate/{partnerId}")
    public ResponseEntity<?> reportGenerate(@PathVariable Integer partnerId) {
        if (partnerRepository.existsById(partnerId)) {
            Partner partner = partnerRepository.findById(partnerId).get();
            String nomeArquivo = "/Users/vitormoura/Desktop/reportFiles/" +
                    partner.getName().replace(" ", "-") + "-Capaigns.txt";

            List<Campaign> listaCampanhas = campaignRepository.findAllByPartnerPartnerId(partnerId);

            PartnerCampaignTxtFileService.CapaignsPartnerTxtGenerate(listaCampanhas, nomeArquivo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(204).build();
    }

}
