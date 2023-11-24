package com.psychoamj.aj4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psychoamj.aj4.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<String> findAllBookTitles();
}
