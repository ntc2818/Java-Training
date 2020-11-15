package com.miniproject.booksManagementSys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.booksManagementSys.bean.Book;
import com.miniproject.booksManagementSys.bean.Review;

@Repository
public interface ReviewRepositry extends JpaRepository<Review, Integer> {

	List<Review> findByRatingBetween(int min, int max);

	List<Review> findByReviewContainingIgnoreCase(String text);

	



}
