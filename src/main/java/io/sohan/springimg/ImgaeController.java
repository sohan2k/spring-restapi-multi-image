package io.sohan.springimg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class ImgaeController {

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file")MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize()/1024+"kb");

        String path="D:\\SprngScurty\\IMAGES";

        Files.copy(file.getInputStream(), Paths.get(path+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        return "successfully upload";
    }
}
