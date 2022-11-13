package teste.aular.application;

import teste.aular.domain.entity.Campaign;
import teste.aular.domain.entity.Partner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class PartnerCampaignTxtFileService {

    public static void gravaRegistro(String registro, String nomeArq){
        BufferedWriter saida = null;

        //try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            erro.printStackTrace();
        }

        //try-catch para gravar e fechar o arquivo
        try{
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

    public static void AllCapaignsTxtGenerate(List<Campaign> listaCampaign, String nomeArq){
        int contaRegDados = 0;

        //Monta registro de header
        String header =  "00";
        header += "CAMPAIGN";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        header += "01";

        // Grava registro de header
        gravaRegistro(header, nomeArq);

        //Monta e grava registros de corpo  (ou de dados)
        String corpo;

        for (Campaign c : listaCampaign){
            //Valindando se Partner é diferente de null porque também existem campanhas de hoteis
            if (c.getPartner() != null ) {
                corpo = "02";
                corpo += String.format("%06d", c.getCampaignId());
                corpo += String.format("%-6.6s", c.getType());
                corpo += String.format("%08.2f", c.getValue());
                corpo += String.format("%06d", c.getClick());
                corpo += String.format("%-10.10s", c.getStartedAt());
                corpo += String.format("%-10.10s\n", c.getFinishedAt());
                corpo += "03";
                corpo += String.format("%06d", c.getPartner().getPartnerId());
                corpo += String.format("%-50.50s", c.getPartner().getName());
                corpo += String.format("%-40.40s", c.getPartner().getEmail());
                corpo += String.format("%-14.14s", c.getPartner().getDocumentId());
                corpo += String.format("%-5.5s", c.getPartner().isFidelity());
                corpo += String.format("%-14.14s", c.getPartner().getPhoneNumber());
                corpo += String.format("%-19.19s", c.getPartner().getCreatedAt());
                corpo += String.format("%-19.19s", c.getPartner().getUpdatedAt());
                corpo += String.format("%-19.19s", c.getPartner().getDeactivatedAt());
                corpo += String.format("%-5.5s", c.getPartner().getActive());

                gravaRegistro(corpo, nomeArq);
                contaRegDados++;
            }
        }

        //Monta e grava registros do trailer
        String trailer =  "01";
        trailer += String.format("%010d", contaRegDados);

        gravaRegistro(trailer, nomeArq);

    }

    public static void CapaignsPartnerTxtGenerate(List<Campaign> listaCampaign, String nomeArq){
        int contaRegDados = 0;

        //Monta registro de header
        String header =  "00";
        header += "CAMPAIGN";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        header += "01";

        // Grava registro de header
        gravaRegistro(header, nomeArq);

        //Monta e grava registros de corpo  (ou de dados)
        String corpo;

        for (Campaign c : listaCampaign){
            corpo = "02";
            corpo += String.format("%06d", c.getCampaignId());
            corpo += String.format("%-6.6s", c.getType());
            corpo += String.format("%08.2f", c.getValue());
            corpo += String.format("%06d", c.getClick());
            corpo += String.format("%-10.10s", c.getStartedAt());
            corpo += String.format("%-10.10s", c.getFinishedAt());

            gravaRegistro(corpo, nomeArq);
            contaRegDados++;
        }


        //Monta e grava registros do trailer
        String trailer =  "01";
        trailer += String.format("%010d", contaRegDados);

        gravaRegistro(trailer, nomeArq);

    }




}
