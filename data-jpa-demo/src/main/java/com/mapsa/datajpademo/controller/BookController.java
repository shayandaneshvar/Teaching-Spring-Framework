package com.mapsa.datajpademo.controller;

import com.mapsa.datajpademo.dto.BookDto;
import com.mapsa.datajpademo.exceptions.SomeException;
import com.mapsa.datajpademo.service.BookService;
import net.bytebuddy.utility.RandomString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
//@ResponseBody
//@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
//    @RequestMapping(method = RequestMethod.GET, value = "/all")
//    @RequestMapping(method = RequestMethod.HEAD)
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooks() {
        return bookService.readAllBooks();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public BookDto findBookByName(@RequestParam(value = "name") String name) {
        return bookService.findBookByName(name);
    }

    @GetMapping("/search1")
    public ResponseEntity<BookDto> findByNameContaining(@RequestParam String name){
        return ResponseEntity.ok(bookService.findBookByName(name));
    }

    @GetMapping("/some")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            throw new SomeException(RandomString.make());
        }
        return "Hello World";
    }

//    @ExceptionHandler(value = {SomeException.class})
//    public ResponseEntity<?> SomeExceptionHandler(SomeException e){
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }

}
