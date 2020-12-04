package com.mapsa.datajpademo.dto.converters;

import com.mapsa.datajpademo.domain.Book;
import com.mapsa.datajpademo.dto.BookDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class BookToBookDto implements Converter<Book, BookDto> {
    @Override
    public BookDto convert(Book book) {
        Objects.requireNonNull(book);
        BookDto bookDto = new BookDto();
        bookDto.setName(book.getName());
        bookDto.setGenre(book
                .getGenre()
                .stream()
                .map(Enum::toString)
                .collect(Collectors.toList()));
        Optional.ofNullable(book.getPublisher())
                .ifPresent(z -> bookDto.setPublisher(z.getName()));
        return bookDto;
    }

}
