package com.psychoamj.aj4.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychoamj.aj4.models.Book;

@RequestMapping(path = "")
public interface BookRest {
	@GetMapping("category/{category}")
	public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String category);
	
	@GetMapping("id/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer id);

	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks();
}
