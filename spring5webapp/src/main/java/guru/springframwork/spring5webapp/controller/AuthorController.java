/**
 * 
 */
package guru.springframwork.spring5webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframwork.spring5webapp.repositories.AuthorRepository;

/**
 * @author Avik
 *
 */
@Controller
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepo;

	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors";
	}

}
