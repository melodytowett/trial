package com.example.trial;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;

public class Photo {
    @Id
    private Integer id;
    @NotEmpty
    private String fileName;
    @JsonIgnore
    private byte [] data;
    public Photo(String s, String fileName){

    }
    public Photo(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

//    public String getId() {
//        return id;
//    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName(String originalFilename) {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
    }
}
