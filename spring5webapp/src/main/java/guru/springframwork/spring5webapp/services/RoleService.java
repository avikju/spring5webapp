package guru.springframwork.spring5webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import guru.springframwork.spring5webapp.model.Role;

@Service
public class RoleService implements CrudService<Role, Long> {

	@Autowired
	CrudRepository<Role, Long> crudRepo;

	@Override
	public CrudRepository<Role, Long> getCrudRepo() {
		// TODO Auto-generated method stub
		return crudRepo;
	}

}
