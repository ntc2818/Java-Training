package com.miniproject.booksManagementSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.booksManagementSys.bean.Author;
import com.miniproject.booksManagementSys.bean.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

	List<Book> findByAuthorName(String authorName);

}
	