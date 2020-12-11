package com.mapsa.datajpademo.service;

import com.mapsa.datajpademo.dto.BookDto;
import com.mapsa.datajpademo.dto.converters.BookDtoToBook;
import com.mapsa.datajpademo.dto.converters.BookToBookDto;
import com.mapsa.datajpademo.dto.mappers.BookMapper;
import com.mapsa.datajpademo.exceptions.NotFoundException;
import com.mapsa.datajpademo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private BookToBookDto bookConverter;
    private BookDtoToBook bookDtoConverter;
    private BookMapper bookMapper;
//    private SessionFactory sessionFactory;

    @Autowired
    public BookService(BookRepository bookRepository,
                       BookToBookDto bookConverter,
                       BookDtoToBook bookDtoConverter, BookMapper bookMapper
            /*, SessionFactory sessionFactory*/) {
//        this.sessionFactory = sessionFactory;
        this.bookMapper = bookMapper;
        this.bookDtoConverter = bookDtoConverter;
        this.bookConverter = bookConverter;
        this.bookRepository = bookRepository;
    }

    @Transactional()
    public List<BookDto> readAllBooks() {
//        Session session = sessionFactory.getCurrentSession().getSession();
//        Transaction transaction = session.getTransaction();
        List<BookDto> list = null;
//        try {
//            transaction.begin();
        list = bookRepository.findAll()
                .stream()
//                .map(bookConverter::convert)
                .map(bookMapper::bookToDto)
                .collect(Collectors.toList());
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        }
        return list;

    }

    public BookDto createBook(BookDto bookDto) {
        return bookConverter
                .convert(bookRepository.save(bookDtoConverter.convert(bookDto)));
    }

    public BookDto findBookByName(String name) {
        return bookMapper.bookToDto(bookRepository
                .findBookByNameContaining(name)
                .orElseThrow(() ->
                        new NotFoundException("No book with name like = " +
                                name + " exists!")));
    }
}
