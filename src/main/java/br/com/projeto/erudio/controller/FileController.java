package br.com.projeto.erudio.controller;

import br.com.projeto.erudio.services.FileStorageService;
import br.com.projeto.erudio.vo.v1.UploaFileResponseVO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Tag(name = "File EndPoint")
@RestController
@RequestMapping(value = "/api/file/v1")
public class FileController {


    private Logger logger = Logger.getLogger(FileController.class.getName());

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public UploaFileResponseVO uploadFileResponseVO(@RequestParam("file") MultipartFile file) {
        logger.info("Storing file to  disk...");
        var fileNameStorage = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/v1/downloadFile/")
                .path(fileNameStorage)
                .toUriString();

        return new UploaFileResponseVO(fileNameStorage, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultiFile")
    public List<UploaFileResponseVO> uploadMultFileResponseVO(@RequestParam("files") MultipartFile[] files) {
        logger.info("Storing files to  disk...");

        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFileResponseVO(file))
                .collect(Collectors.toList());

    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFileResponseVO(@PathVariable String fileName, HttpServletRequest httpServletRequest) {
        logger.info("Download file to  disk...");

        Resource resource = fileStorageService.loadFileAsResource(fileName);

        String contentType = "";

        try {
            contentType = httpServletRequest.getServletContext()
                    .getMimeType(resource.getFile().getAbsolutePath());
        } catch (Exception e) {
            logger.info("Nao foi determinado o tipo de arquivo, para Download !!!");
        }

        if (contentType.isBlank()) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
