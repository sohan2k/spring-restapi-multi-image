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

    public String path="D:\\SprngScurty\\IMAGES";
    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file")MultipartFile[] files) throws IOException {

        int i=0;

        for(MultipartFile file: files) {
            String fname=i+file.getOriginalFilename();
            Files.copy(file.getInputStream(), Paths.get(path+ File.separator+fname), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(file.getOriginalFilename());
            System.out.println(file.getName());
            System.out.println(file.getContentType());
            System.out.println(file.getSize()/1024+"kb");
            System.out.println("==============================");
            i++;
        }
//        Files.copy(file.getInputStream(), Paths.get(path+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        return "successfully upload";
    }
}
