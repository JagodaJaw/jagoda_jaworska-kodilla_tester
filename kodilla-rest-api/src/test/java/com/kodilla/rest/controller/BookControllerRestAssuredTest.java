package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;

@ExtendWith(MockitoExtension.class)
class BookControllerRestAssuredTest {
    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(bookController);
    }

    @Test
    void shouldFetchBooks() {
        // given
        Mockito.when(bookService.getBooks())
                .thenReturn(List.of(
                        new BookDto("Title 1", "Author 1"),
                        new BookDto("Title 2", "Author 2")
                ));

        // when then
        when()
                .get("/books")
        .then()
                .body("$.size()", Matchers.equalTo(2))
                .body("[0].title", Matchers.equalTo("Title 1"))
                .body("[0].author", Matchers.equalTo("Author 1"))
                .body("[1].title", Matchers.equalTo("Title 2"))
                .body("[1].author", Matchers.equalTo("Author 2"))
                .status(HttpStatus.OK);
    }

    @Test
    void addTest() {
        // given
        BookDto bookDto = new BookDto("Title 1", "Author 1");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);

        // when then
        given()
                .contentType(ContentType.JSON)
                .body(jsonContent)
        .when()
                .post("/books")
        .then()
                .status(HttpStatus.OK);
        Mockito.verify(bookService).addBook(bookDto);
    }

    @Test
    void shouldDeleteBook() {
        // given
        BookDto bookDto = new BookDto("Title 1", "Author 1");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);
        Mockito.when(bookService.deleteBook(bookDto)).thenReturn(true);

        // when then
        given()
                .contentType(ContentType.JSON)
                .body(jsonContent)
        .when()
                .delete("/books")
        .then()
                .status(HttpStatus.NO_CONTENT);
        Mockito.verify(bookService).deleteBook(bookDto);
    }

    @Test
    void shouldReturnNotFoundWhenDeletingMissingBook() {
        // given
        BookDto bookDto = new BookDto("Title 1", "Author 1");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto);
        Mockito.when(bookService.deleteBook(bookDto)).thenReturn(false);

        // when then
        given()
                .contentType(ContentType.JSON)
                .body(jsonContent)
        .when()
                .delete("/books")
        .then()
                .status(HttpStatus.NOT_FOUND);
        Mockito.verify(bookService).deleteBook(bookDto);
    }
}
