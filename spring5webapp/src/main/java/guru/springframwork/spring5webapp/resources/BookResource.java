/**
 * 
 */
package guru.springframwork.spring5webapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import guru.springframwork.spring5webapp.data.AppConstants;
import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.model.Book;
import guru.springframwork.spring5webapp.model.Publisher;
import guru.springframwork.spring5webapp.services.BookService;
import guru.springframwork.spring5webapp.services.CrudService;

/**
 * @author Avik
 *
 */
@RestController
@RequestMapping("/books")
public class BookResource {

	@Autowired
	private BookService bookService;
	@Autowired
	private CrudService<Author, Long> authorCrudService;
	@Autowired
	private CrudService<Publisher, Long> publisherCrudService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Book saveBook(@RequestBody Book book) {
		authorCrudService.create(book.getAuthors());
		publisherCrudService.create(book.getPublisher());
		return bookService.create(book);
	}

	@GetMapping
	public Iterable<Book> getBooks(@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_NO) int pageNo,
			@RequestParam(defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
			@RequestParam(required = false) String sortBy, @RequestParam(defaultValue = "false") boolean all,
			@RequestParam(required = false) Sort.Direction sortDirection) {
		if (all) {
			return bookService.findAll();
		} else {
			return bookService.findByPageNoWihSorting(pageNo, pageSize, sortBy, sortDirection);
		}
	}

	@PutMapping
	public Book updateBook(@RequestBody Book book) {
		return bookService.update(book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable long id) {
		bookService.deleteById(id);
	}
}
