package teste.aular.application;

import org.springframework.beans.factory.annotation.Autowired;
import teste.aular.domain.contract.LeadPetRepository;
import teste.aular.domain.contract.LeadPetTutorRepository;
import teste.aular.domain.entity.LeadPet;
import teste.aular.domain.entity.LeadPetTutor;
import teste.aular.domain.entity.Pet;
import teste.aular.domain.entity.PetTutor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeadTxtFile {

    @Autowired
    private static LeadPetRepository leadPetRepository;

    @Autowired
    private static LeadPetTutorRepository leadPetTutorRepository;

    private static List<LeadPetTutor> listLeadPetTutorReaded;
    private static List<LeadPet> listLeadPetReaded;

    public static void lerArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        Integer leadPetTutorId, leadPetId;
        String name, email, password, documentId, phoneNumber;
        String specie, breed, healthDescription;
        LocalDate birthdate;
        Integer leadPetTutorIdReaded;
        int contaRegDadoLido = 0;
        int qtdRegDadoGravado;

        listLeadPetTutorReaded = new ArrayList<>();
        listLeadPetReaded = new ArrayList<>();


        // try-catch para abrir o arquivo
        try{
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
        }

        //try-catch para ler e fechar o arquivo
        try {
            //leitura do primeiro registro do arquivo
            registro = entrada.readLine();

            while (registro != null) {
                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("00")){
                    System.out.println("Registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 16));
                    System.out.println("Data/hora da geração do arquivo: " + registro.substring(16, 36));
                    System.out.println("Versão do layout: " + registro.substring(36, 38));
                }
                else if (tipoRegistro.equals("01")){
                    System.out.println("Registro de trailer");
                    qtdRegDadoGravado = Integer.parseInt(registro.substring(2,7));
                    System.out.println("Quantidade de registros de dados lidos: " + contaRegDadoLido);
                    System.out.println("Quantidade de registros de dados gravados: " + qtdRegDadoGravado);
                    if (contaRegDadoLido == qtdRegDadoGravado){
                        System.out.println("Quantidade de registros de dados lidos compatível " +
                                "com quantidade de registro de dados gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros de dados lidos incompatível " +
                                "com quantidade de registro de dados gravados");
                    }
                }
                else if (tipoRegistro.equals("02")) {
                    System.out.println("Registro de corpo do Pet Tutor");
                    leadPetTutorId = Integer.valueOf(registro.substring(2,8));
                    name = registro.substring(8, 58).trim();
                    email = registro.substring(58,98).trim();
                    password = registro.substring(98, 104).trim();
                    documentId = registro.substring(104, 115).trim();
                    phoneNumber = registro.substring(115, 129).trim();
                    contaRegDadoLido++;

                    LeadPetTutor leadPetTutor = new LeadPetTutor(leadPetTutorId, name, email, password, documentId, phoneNumber);
                    //leadPetTutorRepository.save(leadPetTutor);
                    listLeadPetTutorReaded.add(leadPetTutor);
                    System.out.println(leadPetTutor);
                }
                else if (tipoRegistro.equals("03")) {
                    System.out.println("Registro de corpo do Pet");
                    leadPetId = Integer.valueOf(registro.substring(2,8));
                    name = registro.substring(8, 58).trim();
                    specie = registro.substring(58, 78).trim();
                    breed = registro.substring(78, 118).trim();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    birthdate = LocalDate.parse(registro.substring(118, 128), formatter);
                    healthDescription = registro.substring(128, 228).trim();
                    leadPetTutorIdReaded = Integer.valueOf(registro.substring(228,234));
                    
                    LeadPetTutor leadPetTutorById = null;
                    for (LeadPetTutor leadPetTutorReaded: listLeadPetTutorReaded){
                        if (leadPetTutorReaded.getLeadPetTutorId().equals(leadPetTutorIdReaded)){
                            leadPetTutorById = leadPetTutorReaded;
                        }
                    }
                    contaRegDadoLido++;
                    LeadPet leadPet = new LeadPet(leadPetId, name, specie, breed, birthdate, healthDescription, leadPetTutorById);
                    //leadPetRepository.save(leadPet);
                    listLeadPetReaded.add(leadPet);
                    System.out.println(leadPet);
                }
                else {
                    System.out.println("Tipo de registro inválido");
                }
                // Lê o próximo registro
                registro = entrada.readLine();
            }
            // Fecha o arquivo
            entrada.close();
        }
        catch (IOException erro){
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }
    }


    public static List<LeadPetTutor> getListLeadPetTutorReaded() {
        return listLeadPetTutorReaded;
    }

    public static void setListLeadPetTutorReaded(List<LeadPetTutor> listLeadPetTutorReaded) {
        LeadTxtFile.listLeadPetTutorReaded = listLeadPetTutorReaded;
    }

    public static List<LeadPet> getListLeadPetReaded() {
        return listLeadPetReaded;
    }

    public static void setListLeadPetReaded(List<LeadPet> listLeadPetReaded) {
        LeadTxtFile.listLeadPetReaded = listLeadPetReaded;
    }
}
