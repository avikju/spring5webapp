/**
 * 
 */
package guru.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframwork.spring5webapp.model.Publisher;

/**
 * @author Avik
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
