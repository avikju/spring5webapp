/**
 * 
 */
package guru.springframwork.spring5webapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.services.CrudService;

/**
 * @author Avik
 *
 */
@RestController
@RequestMapping("/authors")
public class AuthorResource {

	@Autowired
	private CrudService<Author, Long> crudService;

	@GetMapping
	public Iterable<Author> getAuthors() {
		return crudService.findAll();
	}

}
