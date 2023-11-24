package com.psychoamj.aj4.restImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psychoamj.aj4.models.Book;
import com.psychoamj.aj4.rest.BookRest;
import com.psychoamj.aj4.serviceImpl.BookServiceImpl;

@RestController
public class BookRestImpl implements BookRest {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	@Override
	public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable("category") String category) {
		List<Book> books = bookServiceImpl.findAllBookByCategory(category);
		return new ResponseEntity<>(books, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Book> getBookById(Integer id) {
		Book book = bookServiceImpl.findBookById(id);

		if (book != null) {
			return ResponseEntity.ok(book);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookServiceImpl.findAllBooks();
		if (books != null) {
			return ResponseEntity.ok(books);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
