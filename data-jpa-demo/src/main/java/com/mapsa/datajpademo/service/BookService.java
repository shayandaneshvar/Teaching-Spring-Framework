package com.mapsa.datajpademo.service;

import com.mapsa.datajpademo.dto.BookDto;
import com.mapsa.datajpademo.dto.converters.BookDtoToBook;
import com.mapsa.datajpademo.dto.converters.BookToBookDto;
import com.mapsa.datajpademo.dto.mappers.BookMapper;
import com.mapsa.datajpademo.exceptions.NotFoundException;
import com.mapsa.datajpademo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private BookToBookDto bookConverter;
    private BookDtoToBook bookDtoConverter;
    private BookMapper bookMapper;

    @Autowired
    public BookService(BookRepository bookRepository,
                       BookToBookDto bookConverter,
                       BookDtoToBook bookDtoConverter, BookMapper bookMapper) {
        this.bookMapper = bookMapper;
        this.bookDtoConverter = bookDtoConverter;
        this.bookConverter = bookConverter;
        this.bookRepository = bookRepository;
    }


    public List<BookDto> readAllBooks() {
        return bookRepository.findAll()
                .stream()
//                .map(bookConverter::convert)
                .map(bookMapper::bookToDto)
                .collect(Collectors.toList());
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
