package com.mapsa.datajpademo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "BOOK")
@Table(name = "BOOK")
//@SequenceGenerator(sequenceName = "?")
//@SecondaryTable(name = "safaf", pkJoinColumns = @PrimaryKeyJoinColumn)
public class Book extends BaseEntity<Long> {
    @Basic(fetch = FetchType.EAGER)
    @Column(/*name = "name",*/length = 100)
    private String name;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "summary_id")
    private Summary summary;

    @Embedded
    private Catalog catalog;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pub_id")
    private Publisher publisher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BOOK_AUTHOR", joinColumns = @JoinColumn(name = "BID"),
            inverseJoinColumns = @JoinColumn(name = "AID"))
    private List<Author> authorList = new ArrayList<>();

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Genre> genre = new ArrayList<>();

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
