package guru.springframwork.spring5webapp.mocker;

import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.model.Book;
import guru.springframwork.spring5webapp.model.Publisher;

public class MockModel {

	public static Author mockAuthor_withIds() {

		Author eric = new Author("Eric", "Evans");
		eric.setId(1L);
		Publisher harper = new Publisher("Harper Collins", "USA");
		harper.setId(1L);
		Book ddd = new Book("1234", "Domain Driven Design", harper);
		ddd.setId(1L);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		return eric;
	}

	public static Author mockAuthor_withOutIds() {

		Author eric = new Author("Eric", "Evans");
		Publisher harper = new Publisher("Harper Collins", "USA");
		Book ddd = new Book("1234", "Domain Driven Design", harper);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		return eric;
	}

}
