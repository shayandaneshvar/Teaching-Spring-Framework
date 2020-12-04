package com.mapsa.datajpademo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
//@DiscriminatorValue(value = "PERSON")
public class Publisher extends Person {
    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
