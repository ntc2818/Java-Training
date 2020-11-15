package com.miniproject.booksManagementSys.service;

import java.util.List;

import com.miniproject.booksManagementSys.bean.Author;
import com.miniproject.booksManagementSys.bean.Book;
import com.miniproject.booksManagementSys.bean.Review;

public interface BookService {
	
	List<Book> getAllBooks(); //list all books
	
	void addBook(Book book);  //create new book

	Book getBookByIsbn(Integer isbn);  //book by isbn
	
	void updateBook(Integer isbn,Book book);  // update the book

	void deleteBook(Integer isbn); //delete book
	
    List<Book> getBookByAuthorName(String authorName); //get book by author


	
	 
}
