package com.miniproject.booksManagementSys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.booksManagementSys.bean.Book;
import com.miniproject.booksManagementSys.bean.Review;
import com.miniproject.booksManagementSys.repository.BooksRepository;
import com.miniproject.booksManagementSys.repository.ReviewRepositry;
import com.miniproject.booksManagementSys.service.ReviewService;

@Service
public class DefaultReviewService implements ReviewService {

	@Autowired
	ReviewRepositry reviewRepository;
	
	@Autowired
	BooksRepository bookRepository;
	
	@Override
	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	@Override
	public void addNewReview(Integer isbn,Review review) {
		Book existingBook=bookRepository.findById(isbn).orElse(null);
		if(existingBook==null)
			return; 
		review.setBooks(existingBook);
		reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReviewsForReviewId(Integer isbn) {
		return (List<Review>) reviewRepository.findById(isbn).orElse(null);
	}

	@Override
	public List<Review> getBooksInRatingRange(int min, int max) {
		return reviewRepository.findByRatingBetween(min,max);
	}
  
	@Override
	public List<Review> getReviewContainingText(String text) {
		return reviewRepository.findByReviewContainingIgnoreCase(text);
	}
	
}
