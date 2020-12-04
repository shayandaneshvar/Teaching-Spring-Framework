package com.mapsa.datajpademo.dto.mappers;

import com.mapsa.datajpademo.domain.Book;
import com.mapsa.datajpademo.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookMapper {
    //    BookMapper bookMapper = Mappers.getMapper(BookMapper.class);
    @Mappings(
            {@Mapping(source = "book.publisher.name", target = "publisher")
            ,/*@Mapping(source = ,target = )*/})
    BookDto bookToDto(Book book);

//    Book bookDtoToBook(BookDto bookDto);
}
