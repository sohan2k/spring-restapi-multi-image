package io.sohan.springimg.service;

import io.sohan.springimg.dtos.ImageDto;
import io.sohan.springimg.entities.Images;
import io.sohan.springimg.repository.ImageRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
@Service
public class ImageService {
    private ImageRepo imageRepo;

    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }
    public ImageDto upload(ImageDto imageDto){

            Images images=DtoToImage(imageDto);
            imageRepo.save(images);
        return imageDto;
    }

    public Images DtoToImage(ImageDto imageDto){
        Images images=new Images();
        images.setId(imageDto.getId());
        images.setExtension(imageDto.getExtension());
        images.setName(imageDto.getName());
        images.setSize(imageDto.getSize());
        images.setPath(imageDto.getPath());
        return images;
    }
    public ImageDto toImageDto(Images images){
        ImageDto imageDto=new ImageDto();
        imageDto.setId(images.getId());
        imageDto.setName(images.getName());
        imageDto.setExtension(images.getExtension());
        imageDto.setSize(images.getSize());
        imageDto.setPath(images.getPath());
        return imageDto;
    }
}
//System.out.println(file.getOriginalFilename());
//        System.out.println(file.getName());
//        System.out.println(file.getContentType());
//        System.out.println(file.getSize()/1024+"kb");
//        System.out.println("==============================");