package teste.aular.application;

import teste.aular.domain.entity.Partner;
import teste.aular.utils.ListObj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import java.io.FileWriter;

public class FileService {

    public static void gravaArquivoCsv(ListObj<Partner> lista, String nomeArq){
        FileWriter arq = null;
        Formatter saida = null;
        Boolean   deuRuim =false;
        nomeArq +=".csv";

        try{

            arq = new FileWriter(nomeArq);
            saida =new Formatter(arq);
        }catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }
        try{
            for (int i=0; i < lista.getTamanho(); i++){
                Partner p = lista.getElemento(i);
                saida.format("%d;%s;%s;%s;%s;%s;%b\n",
                        p.getPartnerId(),
                        p.getPartnerUuid(),
                        p.getName(),
                        p.getEmail(),
                        p.getDocumentId(),
                        p.isFidelity(),
                        p.getPhoneNumber());
            }
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
            System.out.printf("%6S %6S %30S %30S %10S %12S %7S %12S\n",
                    "id", "uuid", "nome", "email", "password","document id", "fidelity",
                    "phone_number");
            while (entrada.hasNext()){
                int id = entrada.nextInt();
                String uuid = entrada.next();
                String nome = entrada.next();
                String email = entrada.next();
                String password = entrada.next();
                String document_id = entrada.next();
                Boolean fidelity = entrada.nextBoolean();
                String phone_number = entrada.next();
                System.out.printf("%6d %6s %30s %30s %10s %12s %7b %12s",
                        id, uuid, nome,email,password,document_id,fidelity,phone_number);
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
