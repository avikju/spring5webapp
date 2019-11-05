package guru.springframwork.spring5webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import guru.springframwork.spring5webapp.model.Publisher;

@Service
public class PublisherService implements CrudService<Publisher, Long> {

	@Autowired
	CrudRepository<Publisher, Long> crudRepo;

	@Override
	public CrudRepository<Publisher, Long> getCrudRepo() {
		return crudRepo;
	}

}
