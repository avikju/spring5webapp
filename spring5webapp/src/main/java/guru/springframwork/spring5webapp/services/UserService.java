package guru.springframwork.spring5webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import guru.springframwork.spring5webapp.model.User;
import guru.springframwork.spring5webapp.repositories.UserRepository;

@Service
public class UserService implements CrudService<User, Long> {

	@Autowired
	UserRepository userRepo;

	@Override
	public CrudRepository<User, Long> getCrudRepo() {
		// TODO Auto-generated method stub
		return userRepo;
	}

	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}

}
