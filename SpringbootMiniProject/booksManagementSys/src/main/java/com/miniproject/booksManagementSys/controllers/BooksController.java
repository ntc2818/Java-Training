package com.miniproject.booksManagementSys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.booksManagementSys.bean.Author;
import com.miniproject.booksManagementSys.bean.Book;
import com.miniproject.booksManagementSys.service.BookService;

@RestController
public class BooksController {

    @Autowired 
    BookService bookService;
	
	
	@GetMapping("/api/books")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@PostMapping(value="/api/books")
	public Book addBook(@RequestBody Book book) {
		bookService.addBook(book);		
		return book;
	}
	
	@GetMapping("/api/books/{isbn}")
	public Book getBookById(@PathVariable("isbn") Integer isbn) {
		return bookService.getBookByIsbn(isbn);
	}

	@PutMapping("/api/books/{isbn}")
	public Book updateTheBook(@PathVariable("isbn") Integer isbn,@RequestBody Book book) {
		bookService.updateBook(isbn,book);
		return book;
	}
	
	@DeleteMapping("/api/books/{isbn}")
    public void delete(@PathVariable("isbn") Integer isbn) {
		bookService.deleteBook(isbn);
    }
	
	
	@GetMapping("/api/books/by/{authorName}")
	public List<Book> getBooksByAuthor(@PathVariable("authorName") String authorName) {
		return bookService.getBookByAuthorName(authorName);
	}
	
}
