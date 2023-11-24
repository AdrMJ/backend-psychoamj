package com.psychoamj.aj4.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psychoamj.aj4.constants.BookConstants;
import com.psychoamj.aj4.models.Book;
import com.psychoamj.aj4.repository.BookRepository;
import com.psychoamj.aj4.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	// Methods for /all
	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public List<String> findAllBooksTitles() {
		List<Book> allBooks = bookRepository.findAll();
		return allBooks.stream().map(Book::getTitle).collect(Collectors.toList());
	}

	// Methods for /category
	@Override
	public List<String> findAllBookTitlesByCategory(String category) {
		List<Book> allBooks = bookRepository.findAll();

		return allBooks.stream()
				.filter(book -> category.equals(book.getDetails().getCategory()))
				.map(Book::getTitle).collect(Collectors.toList());
	}

	@Override
	public List<Book> findAllBookByCategory(String category) {
		List<Book> allBooks = bookRepository.findAll();

		return allBooks.stream()
				.filter(book -> category.equals(book.getDetails().getCategory()))
				.collect(Collectors.toList());
	}

	// Methods for /id
	@Override
	public Book findBookById(Integer id) {
		return bookRepository.findById(id).get();
	}

	// another CRUD methods
	@Override
	public void createBook(Book book) {
		Integer id = book.getId();
		if (bookRepository.existsById(id)) {
			throw new EntityExistsException(BookConstants.ENTITY_EXISTS);
		}
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Book updatedBook) {
		if (bookRepository.existsById(updatedBook.getId())) {
			bookRepository.findById(updatedBook.getId()).ifPresent(existingBook -> {
				BeanUtils.copyProperties(updatedBook, existingBook, "id");
				bookRepository.save(existingBook);
			});
		} else {
			throw new EntityNotFoundException(BookConstants.ENTITY_NOT_EXISTS);
		}

	}

	@Override
	public void deleteBook(Book book) {
		Integer id = book.getId();
		if (bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException(BookConstants.ENTITY_NOT_EXISTS);
		}

	}

}
