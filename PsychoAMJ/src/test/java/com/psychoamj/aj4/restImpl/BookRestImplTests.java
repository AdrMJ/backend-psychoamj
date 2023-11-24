package com.psychoamj.aj4.restImpl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.psychoamj.aj4.models.Book;
import com.psychoamj.aj4.serviceImpl.BookServiceImpl;

public class BookRestImplTests {

	@InjectMocks
	private BookRestImpl bookRestImpl;
	
	@Mock
	private BookServiceImpl bookServiceImpl;
	
	Integer bookId = 1;
	Book book1 = null;
	Book book2 = null;
	Book book3 = null;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		
		book1 = new Book(bookId, null, null, null, null, "Title1", (byte)1); 
		book2 = new Book(2, null, null, null, null, "Title2", (byte)1);
		book3 = new Book(3, null, null, null, null, "Title3", (byte)1);
	}
	
	@Test
	public void	testGetAllBooks() {
		List<Book> books = List.of(book1, book2, book3);
		Mockito.when(bookServiceImpl.findAllBooks()).thenReturn(books);
		
		ResponseEntity<List<Book>> response = bookRestImpl.getAllBooks();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody());
	    assertEquals(3, response.getBody().size());
	}
	@Test
	public void	testGetBooksByCategory() {
		List<Book> books = List.of(book1, book2);
		Mockito.when(bookServiceImpl.findAllBookByCategory("Category")).thenReturn(books);
		
		ResponseEntity<List<Book>> response = bookRestImpl.getBooksByCategory("Category");
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody());
	    assertEquals(2, response.getBody().size());
	}
	@Test
	public void testGetBookById() {
		Mockito.when(bookServiceImpl.findBookById(bookId)).thenReturn(book1);
		ResponseEntity<Book> response = bookRestImpl.getBookById(bookId);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody());
	    assertEquals(1, response.getBody().getId());
	}
	@Test
	public void shouldReturnNotFoundForNonExistingBook() {
	    Mockito.when(bookServiceImpl.findBookById(bookId)).thenReturn(null);
	    ResponseEntity<Book> response = bookRestImpl.getBookById(bookId);

	    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	    assertNull(response.getBody());
	}
}
