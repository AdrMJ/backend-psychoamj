package com.psychoamj.aj4.service;

import java.util.List;

import com.psychoamj.aj4.models.Book;

public interface BookService {

	// Methods for /all
	List<Book> findAllBooks();
	List<String> findAllBooksTitles();

	// Methods for /category
	List<Book> findAllBookByCategory(String category);
	List<String> findAllBookTitlesByCategory(String category);

	// Methods for /id
	Book findBookById(Integer id);

	// another CRUD methods
	void createBook(Book book);
	void updateBook(Book book);
	void deleteBook(Book book);
}
