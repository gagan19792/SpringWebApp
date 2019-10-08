package com.gagan.spring.SpringWebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gagan.spring.SpringWebApp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
