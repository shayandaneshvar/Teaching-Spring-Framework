package com.mapsa.datajpademo.dto;

import com.mapsa.datajpademo.domain.Genre;
import com.mapsa.datajpademo.domain.Publisher;

import java.util.ArrayList;
import java.util.List;

public class BookDto {
    private String name;
    private String publisher;
    private List<String> genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
