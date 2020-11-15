package com.miniproject.booksManagementSys.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.booksManagementSys.bean.Author;
import com.miniproject.booksManagementSys.bean.Book;
import com.miniproject.booksManagementSys.bean.Review;
import com.miniproject.booksManagementSys.repository.BooksRepository;
import com.miniproject.booksManagementSys.service.BookService;

@Service
public class DefaultBookService implements BookService {

	@Autowired
	BooksRepository repository;

	@Override
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	@Override
	public void addBook(Book book) {
		repository.save(book);
	}

	@Override
	public Book getBookByIsbn(Integer isbn) {
		return repository.findById(isbn).orElse(null);
	}

	@Override
	public void updateBook(Integer isbn,Book book) {
		Book existingBook = getBookByIsbn(isbn);
		if (existingBook == null)
			return;
		existingBook.setIsbn(isbn);
		existingBook.setAuthor(book.getAuthor());
		existingBook.setCover(book.getCover());
		existingBook.setTitle(book.getTitle());
		existingBook.setDescription(book.getDescription());
		existingBook.setTag(book.getTag());
		existingBook.setCover(book.getCover());
		//existingBook.setReviews(book.getReviews());
		repository.save(existingBook);
	}

	@Override
	public void deleteBook(Integer isbn) {
		repository.findById(isbn).orElse(null);
		repository.deleteById(isbn);
	}

	@Override
	public List<Book> getBookByAuthorName(String authorName) {
		return repository.findByAuthorName(authorName);
	}


}
