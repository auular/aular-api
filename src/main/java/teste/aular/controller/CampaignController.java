package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.aular.application.PartnerCampaignTxtFileService;
import teste.aular.domain.contract.CampaignRepository;
import teste.aular.domain.contract.PartnerRepository;
import teste.aular.domain.entity.Campaign;
import teste.aular.domain.entity.Partner;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @PostMapping
    public ResponseEntity<Campaign> addCampaign(@RequestBody @Valid Campaign campaign) {
        campaignRepository.save(campaign);
        return ResponseEntity.status(201).body(campaign);
    }

    @GetMapping
    public ResponseEntity<List<Campaign>> getCampaign() {
        List<Campaign> list = campaignRepository.findAll();
        return list.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(list);
    }

    @GetMapping("/allCapaignsTxtGenerate")
    public ResponseEntity<?> allTxtGenerate() {

        PartnerCampaignTxtFileService.AllCapaignsTxtGenerate(
                campaignRepository.findAll(),
                "All-Campaigns.txt");

        return ResponseEntity.status(200).build();
    }

    @GetMapping("/partnersCampaignTxtGenerate/{partnerId}")
    public ResponseEntity<?> txtGenerate(@PathVariable Integer partnerId){
        if (partnerRepository.existsById(partnerId)) {
            Partner partner = partnerRepository.findById(partnerId).get();
            String nomeArquivo = partner.getName() + "-Capaigns.txt";

            List<Campaign> listaCampanhas = campaignRepository.findAllByPartnerPartnerId(partnerId);

            PartnerCampaignTxtFileService.CapaignsPartnerTxtGenerate(listaCampanhas, nomeArquivo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(204).build();
    }


}
