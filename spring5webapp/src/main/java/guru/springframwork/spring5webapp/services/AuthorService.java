package guru.springframwork.spring5webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import guru.springframwork.spring5webapp.model.Author;

@Component
public class AuthorService implements CrudService<Author, Long> {

	@Autowired
	CrudRepository<Author, Long> crudRepo;

	@Override
	public CrudRepository<Author, Long> getCrudRepo() {
		return crudRepo;
	}

}
