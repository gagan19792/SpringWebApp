package com.gagan.spring.SpringWebApp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.gagan.spring.SpringWebApp.model.Author;
import com.gagan.spring.SpringWebApp.model.Book;
import com.gagan.spring.SpringWebApp.model.Publisher;
import com.gagan.spring.SpringWebApp.repositories.AuthorRepository;
import com.gagan.spring.SpringWebApp.repositories.BookRepository;
import com.gagan.spring.SpringWebApp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	private static Logger logger = LoggerFactory.getLogger(DevBootstrap.class);
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, 
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository= publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("starting onApplicationEvent....");
		initData();
		logger.info("completd onApplicationEvent....");
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher();
		publisher.setName("Gagan");
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design","1234",publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod","Johnson");
		Book noEJB = new Book("J2EE Development without EJB","2344",publisher);
		eric.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	
	}

}
