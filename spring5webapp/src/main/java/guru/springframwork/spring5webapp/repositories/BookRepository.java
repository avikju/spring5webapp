/**
 * 
 */
package guru.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframwork.spring5webapp.model.Book;

/**
 * @author Avik
 *
 */
public interface BookRepository extends CrudRepository<Book,Long>{

}
