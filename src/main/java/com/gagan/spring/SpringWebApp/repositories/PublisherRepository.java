package com.gagan.spring.SpringWebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gagan.spring.SpringWebApp.model.Book;
import com.gagan.spring.SpringWebApp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
