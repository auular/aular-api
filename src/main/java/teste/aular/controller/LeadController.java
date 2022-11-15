package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import teste.aular.utils.FilaObj;
import teste.aular.application.LeadTxtFile;
import teste.aular.domain.contract.LeadPetRepository;
import teste.aular.domain.contract.LeadPetTutorRepository;
import teste.aular.domain.entity.LeadPet;
import teste.aular.domain.entity.LeadPetTutor;

import java.util.List;


@RestController
@RequestMapping("/leads")
public class LeadController {

    @Autowired private JavaMailSender mailSender;
    @Autowired
    private LeadPetTutorRepository leadPetTutorRepository;

    @Autowired
    private LeadPetRepository leadPetRepository;

    @GetMapping
    public ResponseEntity<List<LeadPet>> getPetTutors() {
        List<LeadPet> lista = leadPetRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    FilaObj<LeadPetTutor> filaLeadPetTutor;
    FilaObj<LeadPet> filaLeadPet;

    @PostMapping("/scheduleLeads")
    public ResponseEntity<FilaObj<LeadPet>> saveLeadPetTutor() {
        LeadTxtFile.lerArquivoTxt("LEADS.TXT");

        LeadTxtFile lista1 = new LeadTxtFile();
        filaLeadPetTutor = new FilaObj<>(lista1.getListLeadPetTutorReaded().size());
        for (LeadPetTutor leadPetTutor : lista1.getListLeadPetTutorReaded()){
            filaLeadPetTutor.insert(leadPetTutor);
        }

        LeadTxtFile lista2 = new LeadTxtFile();
        filaLeadPet = new FilaObj<>(lista2.getListLeadPetReaded().size());
        for (LeadPet leadPet : lista2.getListLeadPetReaded()){
            filaLeadPet.insert(leadPet);
        }

        return filaLeadPet.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(filaLeadPet);

    }

    @PostMapping("/saveLeads")
    public ResponseEntity<?> txtReading(){

        if (filaLeadPet == null || filaLeadPet.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        else {
            while (!filaLeadPetTutor.isEmpty()) {
                leadPetTutorRepository.save(filaLeadPetTutor.poll());
            }
            while (!filaLeadPet.isEmpty()) {
                leadPetRepository.save(filaLeadPet.poll());
            }
            return ResponseEntity.status(200).build();
        }
    }

    @RequestMapping(path = "/email-send", method = RequestMethod.GET)
    public String sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Teste 4 de envio de e-mail");
        message.setTo("vitormoura@me.com");
        message.setFrom("vitormouramusico@gmail.com");

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }

}
