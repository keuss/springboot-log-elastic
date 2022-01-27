package com.keuss.book.api.controllers;

import com.keuss.book.api.exceptions.BadRequest;
import com.keuss.book.api.pojo.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Api(tags = {"Book"})
@RestController
@RequestMapping(value = "books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final List<Book> books;

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Value("${my.param}")
    String param;

    public BookController() {
        this.books = new ArrayList<>();
        books.add(new Book(UUID.fromString("70b32248-c6ef-4bdb-b88a-db1f58b85e1b"), "lord of the rings 1", "J. R. R. Tolkien"));
        books.add(new Book(UUID.fromString("8a97b90a-0490-4651-9e79-a9370aa80dfb"), "lord of the rings 2", "J. R. R. Tolkien"));
        books.add(new Book(UUID.fromString("d34198e9-d6fe-412c-b3dc-2c205e9c0830"), "lord of the rings 3", "J. R. R. Tolkien"));
    }

    @ApiOperation(value = "Get all Books")
    @GetMapping
    public List<Book> getAll() {
        LOGGER.info("param [{}]", param);
        return this.books;
    }

    @ApiOperation(value = "Get Book by Id")
    @GetMapping(value = "{id}")
    public Optional<Book> getById(@ApiParam(value = "Book id", required = true, example = "d34198e9-d6fe-412c-b3dc-2c205e9c0830") @PathVariable String id) {
        try {
            var uuid = UUID.fromString(id);
            return this.books.stream().filter(book -> book.getId().equals(uuid)).findFirst();
        } catch (IllegalArgumentException e) {
            LOGGER.error("{} is not a valid UUID !", id);
            throw new BadRequest();
        }
    }

    @ApiOperation(value = "Add Book", response = Book.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book add(@ApiParam(value = "Book to Add", required = true) @RequestBody Book book) {
        UUID uuid = UUID.randomUUID();
        book.setId(uuid);
        this.books.add(book);
        // Just for MDC test
        String businessRef = String.valueOf(Timestamp.from(Instant.now()).getTime());
        // Mapped Diagnostic Context test
        try (var ignored = MDC.putCloseable("businessRef", businessRef)) {
            // Also, multiple fields are supported, it is optional to use them in the message
            LOGGER.debug("book created {}", kv("bookId", uuid));
        }
        return book;
    }
}
