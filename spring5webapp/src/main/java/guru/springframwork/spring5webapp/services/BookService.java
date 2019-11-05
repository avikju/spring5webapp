package guru.springframwork.spring5webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import guru.springframwork.spring5webapp.model.Book;
import guru.springframwork.spring5webapp.repositories.BookRepository;

@Component
public class BookService implements CrudService<Book, Long> {

	@Autowired
	BookRepository bookRepo;

	@Override
	public CrudRepository<Book, Long> getCrudRepo() {
		return bookRepo;
	}

	public Iterable<Book> findByPageNoWihSorting(int pageNo, int pageSize, String sortBy,
			Sort.Direction sortDirection) {

		return bookRepo.findAll(PageRequest.of(pageNo, pageSize,
				!ObjectUtils.isEmpty(sortBy)
						? Sort.by(sortDirection != null ? sortDirection : Sort.Direction.ASC, sortBy)
						: Sort.unsorted()));
	}

}
