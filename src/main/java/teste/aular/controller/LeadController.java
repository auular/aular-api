package teste.aular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import teste.aular.utils.Disc;
import teste.aular.utils.FilaObj;
import teste.aular.application.LeadTxtFile;
import teste.aular.domain.contract.LeadPetRepository;
import teste.aular.domain.contract.LeadPetTutorRepository;
import teste.aular.domain.entity.LeadPet;
import teste.aular.domain.entity.LeadPetTutor;

import javax.mail.Multipart;
import java.util.List;


@RestController
@RequestMapping("/leads")
public class LeadController {

    @Autowired private JavaMailSender mailSender;
    @Autowired
    private LeadPetTutorRepository leadPetTutorRepository;
    @Autowired
    private LeadPetRepository leadPetRepository;

    @Autowired
    private Disc disc;

    @GetMapping
    public ResponseEntity<List<LeadPet>> getLeads() {
        List<LeadPet> lista = leadPetRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @PostMapping("/uploadLeadsFile")
    public void uploadLeadsFile(@RequestParam MultipartFile leadFile) {
        disc.saveLeadFile(leadFile);
        sendMail();
    }

    FilaObj<LeadPetTutor> filaLeadPetTutor;
    FilaObj<LeadPet> filaLeadPet;

    //Lê o arquivo dos Leads (PetTutor e Pet na fila), armazena na fila e dispara o email
    @PostMapping("/scheduleLeads")
    public ResponseEntity<FilaObj<LeadPet>> scheduleLeads() {
        LeadTxtFile.lerArquivoTxt("/Users/vitormoura/Desktop/leadFiles/LEADS.TXT");

        LeadTxtFile lista1 = new LeadTxtFile();
        filaLeadPetTutor = new FilaObj<>(lista1.getListLeadPetTutorReaded().size());
        for (LeadPetTutor leadPetTutor : lista1.getListLeadPetTutorReaded()) {
            filaLeadPetTutor.insert(leadPetTutor);
        }

        LeadTxtFile lista2 = new LeadTxtFile();
        filaLeadPet = new FilaObj<>(lista2.getListLeadPetReaded().size());
        for (LeadPet leadPet : lista2.getListLeadPetReaded()) {
            filaLeadPet.insert(leadPet);
        }

        if (filaLeadPetTutor.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(filaLeadPet);
        }
    }

    // Salva os Leads que estavam na fina no banco de dados
    @PostMapping("/saveLeads")
    public ResponseEntity<?> saveLeads(){

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

    // Método sendMail que dispara o email, endpoint criado para poder terstar apenas o envio
    @GetMapping("/sendEmailTest")
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Leads na fila ");
        message.setText("Novo arquivo com leads na pasta leadsFile.\n\n" +
                "Acesse o link abaixo para verificar os dados do arquivo!");
        message.setTo("contato.auular@gmail.com");
        message.setFrom("contato.auular@gmail.com");

        try {
            mailSender.send(message);
            System.out.println("Email enviado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao enviar email.");
        }
    }

}
