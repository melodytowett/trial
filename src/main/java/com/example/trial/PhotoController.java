package com.example.trial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }


    @GetMapping("/")
    public String hello(){
        return ("Hello Melody You can Do it");
    }
    @GetMapping("/photos")
    public Collection<Photo> get(){
        return photoService.get();
    }
    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photoService.get(id);
        if (photo == null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id){
        Photo photo = photoService.remove(id);
        if (photo == null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/photos")
    public Photo create(@RequestPart ("data")MultipartFile file)throws IOException {
        Photo photo = new Photo("1", "melo.jpg");
        photo.setId(Integer.valueOf(UUID.randomUUID().toString()));
        photo.getFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        photoService.save(Integer.valueOf(photo.getId()),photo);
        return photo;
    }


}
