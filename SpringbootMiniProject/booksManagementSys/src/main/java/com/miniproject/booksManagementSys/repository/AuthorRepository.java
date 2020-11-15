package com.miniproject.booksManagementSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.booksManagementSys.bean.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
