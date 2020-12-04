package com.mapsa.datajpademo.bootstrap;

import com.mapsa.datajpademo.domain.Book;
import com.mapsa.datajpademo.domain.Genre;
import com.mapsa.datajpademo.domain.Publisher;
import com.mapsa.datajpademo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bootstrapper implements CommandLineRunner {
    private BookRepository bookRepository;

    @Autowired
    public Bootstrapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        Book book = new Book();
        book.setName("Java In Action");
        book.getGenre().add(Genre.SCIENCE);

        Publisher publisher = new Publisher();
        publisher.setName("Ali");
        publisher.getBooks().add(book);
        book.setPublisher(publisher);

        bookRepository.save(book);

        Book book1 = new Book();
        book1.setName("Alchemist");
        book1.getGenre().add(Genre.NOVEL);
        bookRepository.save(book1);
    }
}
