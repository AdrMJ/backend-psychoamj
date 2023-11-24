package com.psychoamj.aj4.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.psychoamj.aj4.serviceImpl.BookServiceImpl;

public class BookRepositoryTests {
	@InjectMocks
	private BookServiceImpl bookService;

	@Mock
	private BookRepository bookRepositoryMock;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		List<String> expectedTitles = Arrays.asList("Title1", "Title2");
		Mockito.when(bookRepositoryMock.findAllBookTitles()).thenReturn(expectedTitles);
	}

	@Test
	public void shouldFindAllBookTitles() {

		List<String> titles = bookService.findAllBooksTitles();

		assertEquals(2, titles.size());
		assertTrue(titles.contains("Title1"));
		assertTrue(titles.contains("Title2"));
	}
}
