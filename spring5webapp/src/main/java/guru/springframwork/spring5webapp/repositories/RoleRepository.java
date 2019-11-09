package guru.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframwork.spring5webapp.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
