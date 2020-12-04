package com.mapsa.datajpademo.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Table
@Entity
public class Author extends Person {
    private String pseudonym;

    @ManyToMany(mappedBy = "authorList")
    private List<Book> bookList;
}
