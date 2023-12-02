package com.fatma.fruits.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.fatma.fruits.entities.Image;

public interface ImageService {
 Image uplaodImage(MultipartFile file) throws IOException;
 Image getImageDetails(Long id) throws IOException;
 ResponseEntity<byte[]> getImage(Long id) throws IOException;
 void deleteImage(Long id) ;
 Image uplaodImageFruit(MultipartFile file,Long idFruit) throws IOException;
 List<Image> getImagesParFrui(Long fruiId);
}
