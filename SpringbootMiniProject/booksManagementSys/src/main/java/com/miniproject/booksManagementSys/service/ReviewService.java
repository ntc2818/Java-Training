package com.miniproject.booksManagementSys.service;

import java.util.List;

import com.miniproject.booksManagementSys.bean.Review;

public interface ReviewService {

	List<Review> getAllReviews(); //list of reviews
	
	void addNewReview(Integer isbn,Review review); //add new review
	
	List<Review> getAllReviewsForReviewId(Integer isbn); // review by id
	
	List<Review> getBooksInRatingRange(int min, int max);  //books in rating range

	List<Review> getReviewContainingText(String text); //get review text 
	
}
