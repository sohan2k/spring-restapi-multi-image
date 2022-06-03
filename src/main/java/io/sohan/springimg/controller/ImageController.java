package io.sohan.springimg.controller;

import io.sohan.springimg.dtos.ImageDto;
import io.sohan.springimg.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class ImageController {
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }
        public String path="D:\\SprngScurty\\IMAGES";

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file")MultipartFile[] files) throws IOException {

        for(MultipartFile file: files) {
            Files.copy(file.getInputStream(), Paths.get(path+ File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            ImageDto imageDto=new ImageDto();
            imageDto.setPath(path);
            imageDto.setName(file.getOriginalFilename());
            imageDto.setSize(String.valueOf(file.getSize()));
            imageDto.setExtension(file.getContentType());
            imageService.upload(imageDto);
        }
        return ResponseEntity.ok().body("Successfully");
    }
}
