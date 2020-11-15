package com.miniproject.booksManagementSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.booksManagementSys.bean.Author;
import com.miniproject.booksManagementSys.bean.Book;
import com.miniproject.booksManagementSys.repository.AuthorRepository;
import com.miniproject.booksManagementSys.service.AuthorService;

@Service
public class DefaultAuthorService implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public List<Author> getAllAuthors(){
		return authorRepository.findAll();
	}
	
	@Override
	public void addAuthor(Author author) {
		authorRepository.save(author);
	} 
	
	@Override
	public Author getAuthorById(Integer authorId) {
		return authorRepository.findById(authorId).orElse(null);
	} 
	
	@Override
	public void updateAuthor(Integer authorId,Author author) {
		Author existingAuthor=getAuthorById(authorId);
		if(existingAuthor==null)
			return;
		existingAuthor.setAuthorId(authorId);
		existingAuthor.setBiography(author.getBiography());
		existingAuthor.setName(author.getName());
		existingAuthor.setPhotograph(author.getPhotograph());
		existingAuthor.setBooks(author.getBooks());
		authorRepository.save(existingAuthor);
	}  
	
	@Override
	public void deleteAuthor(Integer authorId) {
	Author existingAuthor=	authorRepository.findById(authorId).orElse(null);
		authorRepository.delete(existingAuthor);	
	}

	 

}
