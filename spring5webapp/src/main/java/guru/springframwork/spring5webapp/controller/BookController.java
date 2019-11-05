/**
 * 
 */
package guru.springframwork.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframwork.spring5webapp.repositories.BookRepository;

/**
 * @author Avik
 *
 */
@Controller
public class BookController {

	@Autowired
	private BookRepository bookRepo;

	@RequestMapping("/all_books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books";
	}

}
