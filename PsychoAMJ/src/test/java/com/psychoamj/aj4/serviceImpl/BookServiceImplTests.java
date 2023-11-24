package com.psychoamj.aj4.serviceImpl;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.psychoamj.aj4.models.Book;
import com.psychoamj.aj4.models.Details;
import com.psychoamj.aj4.repository.BookRepository;

public class BookServiceImplTests {
	
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookServiceImpl bookService;
	
	String category = null;
	
	Details details1 = null;
	Details details2 = null;
	
	Book book1 = null;
	Book book2 = null;
	Book book3 = null;
	Book newBook1 = null;
	
	Book thisBookDoesntExist = null;
	
	List<Book> mockBooks;
		
	@BeforeEach
	public void setUp() {
		category = "category";
		
		details1 = new Details(1, Short.valueOf((short) 22), category, "about book");
		details2 = new Details(2, Short.valueOf((short) 22), "another category", "about book");
		
		book1 = new Book(1, null, details1, null, null, "Title1", (byte)1); 
		book2 = new Book(2, null, details2, null, null, "Title2", (byte)0);
		book3 = new Book(3, null, details2, null, null, "Title3", (byte)0);
		newBook1 = new Book(1, null, details2, null, null, "Title4", (byte)1);
		
		thisBookDoesntExist = new Book(12, null, null, null, null, "ok", (byte)0);
		
		mockBooks = new ArrayList<>();
		mockBooks.add(book1);
		mockBooks.add(book2);
		
		MockitoAnnotations.openMocks(this);
		//finding entity
		Mockito.when(bookRepository.findAll()).thenReturn(mockBooks);
		Mockito.when(bookRepository.findById(anyInt())).thenReturn(Optional.of(book1));
		
		//save entity
		Mockito.when(bookRepository.save(book3)).thenAnswer(invocation -> {
			Book savedBook = invocation.getArgument(0);

			mockBooks.add(savedBook);

			return savedBook;
		});
		
		//delete entity

		Mockito.when(bookRepository.existsById(anyInt())).thenAnswer(invocation -> {
			int bookId = invocation.getArgument(0);
			
			return mockBooks.stream().anyMatch(book -> book.getId() == bookId);
		});
		
		Mockito.doAnswer(invocation -> {
		    Integer deletedBookId = invocation.getArgument(0);

		    mockBooks.removeIf(book -> book.getId() == deletedBookId);

		    return null;
		}).when(bookRepository).deleteById(anyInt());
	}
	
	//Test methods for /all
	
	@Test
	public void shouldBeAbleToGetAllBook() {
		List<Book> result = bookService.findAllBooks();

		assertEquals(mockBooks, result);
	}
	
	@Test
	public void shouldBeAbleToGetAllBookTitles() {
		List<String> result = bookService.findAllBooksTitles();

		List<String> expectedTitles = List.of("Title1", "Title2");
		assertEquals(expectedTitles, result);
	}
	
	//Test methods for /category
	
	@Test
	public void shouldBeAbleToGetAllBooksByCategory() {
		List<Book> result = bookService.findAllBookByCategory(category);

		List<Book> expectedBooks = List.of(book1);
		assertEquals(expectedBooks, result);
	}
	
	@Test
	public void shouldBeAbleToGetAllBookTitlesByCategory() {
		List<String> result = bookService.findAllBookTitlesByCategory(category);

		List<String> expectedTitles = List.of("Title1");
		assertEquals(expectedTitles, result);
	}
	
	//Test methods for /id
	
	@Test
	public void shouldBeAbleToGetBookById() {
		Book result = bookService.findBookById(1);

		Book expectedBook = book1;
		assertEquals(expectedBook, result);
	}
	
	//Test methods for CRUD
	
	@Test
	public void shouldBeAbleToSaveBook() {
		bookService.createBook(book3);
		assertTrue(mockBooks.contains(book3));
	}

	@Test
	public void shouldntBeAbleToSaveSameBookTwice() {
		assertThrows(EntityExistsException.class, () -> bookService.createBook(book1));

	}

	@Test
	public void shouldBeAbleToUpdateBook() {
		bookService.updateBook(newBook1);
		assertTrue(mockBooks.contains(newBook1));
	}
	
	@Test
	public void shouldntBeAbleToUpdateBookWhichNotExists() {
		assertThrows(EntityNotFoundException.class, () -> bookService.updateBook(book3));
	}
	
	@Test
	public void shouldBeAbleToDeleteBook() {
		bookService.deleteBook(book1);

		verify(bookRepository).deleteById(book1.getId());
		assertFalse(mockBooks.contains(book1));
	}
	@Test
	public void shouldntBeAbleToDeleteBookWhichNotExists() {
		assertThrows(EntityNotFoundException.class, () -> bookService.deleteBook(book3));
	}
	
}
