package teste.aular.application;

import org.springframework.beans.factory.annotation.Autowired;
import teste.aular.domain.contract.PetTutorRepository;
import teste.aular.domain.contract.PetRepository;
import teste.aular.domain.entity.Pet;
import teste.aular.domain.entity.PetTutor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PetTutorAndTutorTxtFile {

    @Autowired
    private static PetRepository petRepository;

    @Autowired
    private static PetTutorRepository petTutorRepository;

    private static List<PetTutor> listPetTutorReaded;
    private static List<Pet> listPetReaded;

    public static void lerArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        Integer petTutorId, petId;
        String name, email, password, documentId, phoneNumber, active, isAuthenticated;
        String specie, breed, healthDescription;
        LocalDate birthdate;
        Integer petTutorIdReaded;
        int contaRegDadoLido = 0;
        int qtdRegDadoGravado;

        listPetTutorReaded = new ArrayList<>();
        listPetReaded = new ArrayList<>();


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
                    petTutorId = Integer.valueOf(registro.substring(2,8));
                    name = registro.substring(8, 58).trim();
                    email = registro.substring(58,98).trim();
                    password = registro.substring(98, 104).trim();
                    documentId = registro.substring(104, 115).trim();
                    phoneNumber = registro.substring(115, 129).trim();
                    contaRegDadoLido++;

                    PetTutor pT = new PetTutor(petTutorId, name, email, password, documentId, phoneNumber);
                    //petTutorRepository.save(pT);
                    listPetTutorReaded.add(pT);
                    System.out.println(pT);
                }
                else if (tipoRegistro.equals("03")) {
                    System.out.println("Registro de corpo do Pet");
                    petId = Integer.valueOf(registro.substring(2,8));
                    name = registro.substring(8, 58).trim();
                    specie = registro.substring(58, 78).trim();
                    breed = registro.substring(78, 118).trim();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    birthdate = LocalDate.parse(registro.substring(118, 128), formatter);
                    healthDescription = registro.substring(128, 228).trim();
                    petTutorIdReaded = Integer.valueOf(registro.substring(228,234));
                    
                    PetTutor petTutorById = null;
                    for (PetTutor petTutorReaded: listPetTutorReaded){
                        if (petTutorReaded.getPetTutorId().equals(petTutorIdReaded)){
                            petTutorById = petTutorReaded;
                        }
                    }
                    contaRegDadoLido++;
                    Pet pet = new Pet(petId, name, specie, breed, birthdate, healthDescription, petTutorById);
                    //petRepository.save(pet);
                    listPetReaded.add(pet);
                    System.out.println(pet);
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


    public List<PetTutor> getListPetTutorReaded() {
        return listPetTutorReaded;
    }

    public void setListPetTutorReaded(List<PetTutor> listPetTutorReaded) {
        this.listPetTutorReaded = listPetTutorReaded;
    }

    public List<Pet> getListPetReaded() {
        return listPetReaded;
    }

    public void setListPetReaded(List<Pet> listPetReaded) {
        this.listPetReaded = listPetReaded;
    }
}
