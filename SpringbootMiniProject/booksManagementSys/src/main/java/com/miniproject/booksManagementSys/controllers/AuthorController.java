package com.miniproject.booksManagementSys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.booksManagementSys.bean.Author;
import com.miniproject.booksManagementSys.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService;	
	
	@GetMapping("/api/authors")
	public List<Author>  getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
	@PostMapping(value="/api/authors")
	public Author addAuthor(@RequestBody Author author) {
		  authorService.addAuthor(author);
		  return author;
	}
	
	@GetMapping("/api/authors/{authorId}")
    public Author getAuthorById(@PathVariable("authorId") Integer authorId) {
    	return authorService.getAuthorById(authorId);
    }
	
	@PutMapping("/api/authors/{authorId}")
	public Author updateAuthor(@PathVariable("authorId") Integer authorId, @RequestBody Author author) {
		 authorService.updateAuthor(authorId, author);
		return author;
	}
	
	@DeleteMapping("api/authors/{authorId}")
	public void deleteAuthor(@PathVariable("authorId") Integer authorId) {
		authorService.deleteAuthor(authorId);
	}
	
}

