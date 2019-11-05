/**
 * 
 */
package guru.springframwork.spring5webapp.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import guru.springframwork.spring5webapp.model.Book;

/**
 * @author Avik
 *
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
