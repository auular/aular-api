package teste.aular.application;

import teste.aular.domain.entity.Partner;
import teste.aular.utils.ListObj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.io.FileWriter;

public class FileService {

    public static void gravaArquivoCsv(ListObj<Partner> lista, String nomeArq){
        FileWriter arq = null;
        Formatter saida = null;
        Boolean   deuRuim =false;
        String registroHeader = "00";
        String registroDetalhe = "02";
        String registroTrailer = "01";
        String tipoArquivo = "Partner";
        String versaoLayout = "01";
        nomeArq +=".csv";

        try{

            arq = new FileWriter(nomeArq);
            saida =new Formatter(arq);
        }catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }
        try{
            //Gravando header
            saida.format("%s;%S;%s;%s\n",
                    registroHeader,
                    tipoArquivo,
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                    versaoLayout
            );
            //Gravando detalhe
            for (int i=0; i < lista.getTamanho(); i++){
                Partner p = lista.getElemento(i);
                saida.format("%s;%d;%s;%s;%s;%s;%b;%s;%s;%s;%s;%b\n",
                        registroDetalhe,
                        p.getPartnerId(),
                        p.getPartnerUuid(),
                        p.getName(),
                        p.getEmail(),
                        p.getDocumentId(),
                        p.isFidelity(),
                        p.getPhoneNumber(),
                        p.getCreatedAt(),
                        p.getUpdatedAt(),
                        p.getDeactivatedAt(),
                        p.getActive()
                );
            }
            //Gravando trailer
            saida.format("%s;%d\n",
                    registroTrailer,
                    lista.getTamanho()
            );

        }
        catch (FormatterClosedException erro){

            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            deuRuim=true;
        }
        finally {
            saida.close();
            try{
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim=true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }

    }

//    public static void leExibeArquivoCsv(String nomeArq){
//
//        FileReader arq = null;
//        Scanner entrada = null;
//        Boolean deuRuim = false;
//        nomeArq +=".csv";
//
//        try{
//            arq = new FileReader(nomeArq);
//            entrada = new Scanner(arq).useDelimiter(";|\\n");
//        }
//        catch (FileNotFoundException erro){
//            System.out.println("Arquivo não encontrado!");
//            System.exit(1);
//
//        }
//    }

    public static void leExibeArquivoCsv(String nomeArq){

        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;
        nomeArq +=".csv";

        try{
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado!");
            System.exit(1);

        }
        try{
            System.out.printf("%2S %36S %50S %40S %15S %8S %14S %20S %20S %20S %8S\n",
                    "id",
                    "uuid",
                    "name",
                    "email",
                    "document id",
                    "fidelity",
                    "phone_number",
                    "created_at",
                    "updated_at",
                    "deactivated_at",
                    "active"
                    );
            while (entrada.hasNext()){
                int id = entrada.nextInt();
                String uuid = entrada.next();
                String name = entrada.next();
                String email = entrada.next();
                String document_id = entrada.next();
                Boolean fidelity = entrada.nextBoolean();
                String phone_number = entrada.next();
                String created_at = entrada.next();
                String updated_at = entrada.next();
                String deactivated_at = entrada.next();
                Boolean active = entrada.nextBoolean();
                System.out.printf("%2d %36s %50s %40s %15d %8b %14s %20s %20s %20s %8b",
                        id,
                        uuid,
                        name,
                        email,
                        document_id,
                        fidelity,
                        phone_number,
                        created_at,
                        updated_at,
                        deactivated_at,
                        active
                );
            }
        }
        catch (NoSuchElementException erro){
            System.out.println("Arquivo com problemas");
            System.out.println(erro);
            erro.printStackTrace();
            deuRuim =true;
        }
        catch (IllegalStateException erro){
            System.out.println("Erro na leitura do arquivo");
            System.out.println(erro);
            erro.printStackTrace();
            deuRuim=true;
        }
        finally {
            entrada.close();
            try{
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim=true;
            }
            if (deuRuim){
                System.exit(1);
            }

        }
    }

//    public static void main(String[] args) {
//        List<Partner> lista =new List<>(5);
//        gravaArquivoCsv( lista, "partner");
//        leExibeArquivoCsv("partner");
//    }
}
