package guru.springframwork.spring5webapp.test.unit.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import guru.springframwork.spring5webapp.mocker.MockModel;
import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.repositories.AuthorRepository;
import guru.springframwork.spring5webapp.services.AuthorService;

//we don't use any spring based annotations here as that's not needed
//we don't need the whole Spring's application context
//MockitoJunitRunner provides an automatic validation of Mockito framework usage
@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceTest {

	// InjectMocks creates the mock object of class AuthorService and also inject
	// any other
	// necessary mocked objects
	@InjectMocks
	private AuthorService authorService;

	// just create mock object of class AuthorRepository
	@Mock
	private AuthorRepository authorRepo;

	@Test
	public void testAuthorCreate() {
		Author authorToSave = MockModel.mockAuthor_withOutIds();
		Author expectedSavedAuthor = MockModel.mockAuthor_withIds();
		when(authorRepo.save(authorToSave)).thenReturn(expectedSavedAuthor);
		Author actualSavedAuthor = authorService.create(authorToSave);
		assertEquals(expectedSavedAuthor.getFirstName(), actualSavedAuthor.getFirstName());
	}

}
