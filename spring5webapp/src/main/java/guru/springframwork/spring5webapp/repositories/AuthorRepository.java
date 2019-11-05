/**
 * 
 */
package guru.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframwork.spring5webapp.model.Author;

/**
 * @author Avik
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long>{

}
