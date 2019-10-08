package com.gagan.spring.SpringWebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gagan.spring.SpringWebApp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
