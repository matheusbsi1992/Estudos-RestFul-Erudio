package br.com.projeto.erudio.services;

import br.com.projeto.erudio.config.FileStorageConfig;
import br.com.projeto.erudio.exceptions.FileStorageException;
import br.com.projeto.erudio.exceptions.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageConfig fileStorageConfig) {
        Path path = Paths.get(fileStorageConfig.getUploadDir())
                .toAbsolutePath()
                .normalize();

        this.fileStorageLocation = path;

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Diretorio nao criado para Upload de arquivos !!!", ex);
        }
    }

    public String storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if (fileName.contains("..") || fileName.contains(".AppImage")) {
            throw new FileStorageException("Desculpa, mas o tipo de arquivo e invalido !!!" + fileName);
        }

        try {

            //mudar linha 42-43, para jogar na nuvem ou os dados em um banco de dados
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;

        } catch (Exception e) {
            throw new FileStorageException("A criacao do arquivo, " + fileName + " para Upload de arquivos falhou !!!", e);
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePathLocation = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePathLocation.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("Arquivo nao encontrado!!!");
            }

        } catch (Exception e) {
            throw new MyFileNotFoundException("File not found" + fileName, e);
        }
    }

}
