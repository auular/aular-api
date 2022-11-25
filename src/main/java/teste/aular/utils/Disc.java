package teste.aular.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Disc {

    @Value("${contact.disc.root}")
    private String root;

    @Value("${contac.disc.lead-file-directory}")
    private String leadFileDirectory;

    public void saveLeadFile(MultipartFile leadFile) {
        this.save(this.leadFileDirectory, leadFile);
    }

    public void save(String diretorio, MultipartFile arquivo){
        Path diretorioPath = Paths.get(this.root, diretorio);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
        }
        catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar o arquivo");
        }
    }
}
