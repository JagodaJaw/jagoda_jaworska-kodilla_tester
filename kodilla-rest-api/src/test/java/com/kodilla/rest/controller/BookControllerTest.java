package com.kodilla.rest.controller;

import com.kodilla.rest.domain.BookDto;
import com.kodilla.rest.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookControllerTest {

    @Test
    void shouldFetchBooks() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        List<BookDto> booksList = new ArrayList<>();
        booksList.add(new BookDto("Title 1", "Author 1"));
        booksList.add(new BookDto("Title 2", "Author 2"));
        Mockito.when(bookServiceMock.getBooks()).thenReturn(booksList);

        //when
        List<BookDto> result = bookController.getBooks();

        //then
        assertThat(result).hasSize(2);
    }

    @Test
    void shouldAddBook() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        BookDto bookDto = new BookDto("Title 1", "Author 1");

        //when
        bookController.addBook(bookDto);

        //then
        Mockito.verify(bookServiceMock).addBook(bookDto);
    }

    @Test
    void shouldDeleteBook() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        BookDto bookDto = new BookDto("Title 1", "Author 1");
        Mockito.when(bookServiceMock.deleteBook(bookDto)).thenReturn(true);

        //when
        ResponseEntity<Void> response = bookController.deleteBook(bookDto);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        Mockito.verify(bookServiceMock).deleteBook(bookDto);
    }

    @Test
    void shouldReturnNotFoundWhenDeletingMissingBook() {
        //given
        BookService bookServiceMock = Mockito.mock(BookService.class);
        BookController bookController = new BookController(bookServiceMock);
        BookDto bookDto = new BookDto("Title 1", "Author 1");
        Mockito.when(bookServiceMock.deleteBook(bookDto)).thenReturn(false);

        //when
        ResponseEntity<Void> response = bookController.deleteBook(bookDto);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        Mockito.verify(bookServiceMock).deleteBook(bookDto);
    }
}
