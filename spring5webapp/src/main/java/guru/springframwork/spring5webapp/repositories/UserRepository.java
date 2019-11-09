package guru.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframwork.spring5webapp.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUserName(String userName);
}
