/**
 * 
 */
package guru.springframwork.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.model.Book;
import guru.springframwork.spring5webapp.model.Publisher;
import guru.springframwork.spring5webapp.repositories.AuthorRepository;
import guru.springframwork.spring5webapp.repositories.BookRepository;
import guru.springframwork.spring5webapp.repositories.PublisherRepository;

/**
 * @author Avik
 *
 */
@Component
public class DevBootstrap {

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private AuthorRepository authorRepo;
	@Autowired
	private PublisherRepository publisherRepo;

	@EventListener
	public void initData(ContextRefreshedEvent arg0) {

		Author eric = new Author("Eric", "Evans");
		Publisher harper = new Publisher("Harper Collins", "USA");
		Book ddd = new Book("1234", "Domain Driven Design", harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		publisherRepo.save(harper);
		authorRepo.save(eric);
		bookRepo.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Publisher wrox = new Publisher("Wrox", "USA");
		Book noEJB = new Book("1235", "J2EE Development without EJB", wrox);
		publisherRepo.save(wrox);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepo.save(rod);
		bookRepo.save(noEJB);
	}

}
