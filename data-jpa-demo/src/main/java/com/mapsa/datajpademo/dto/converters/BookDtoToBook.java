package com.mapsa.datajpademo.dto.converters;

import com.mapsa.datajpademo.domain.Book;
import com.mapsa.datajpademo.domain.Genre;
import com.mapsa.datajpademo.dto.BookDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;
@Component
public class BookDtoToBook implements Converter<BookDto, Book> {
    @Override
    public Book convert(BookDto bookDto) {
        Objects.requireNonNull(bookDto);
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setGenre(bookDto
                .getGenre()
                .stream()
                .map(Genre::valueOf)
                .collect(Collectors.toList()));
        return book;
    }
}
