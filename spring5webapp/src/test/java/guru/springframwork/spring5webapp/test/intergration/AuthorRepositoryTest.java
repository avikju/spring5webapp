package guru.springframwork.spring5webapp.test.intergration;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframwork.spring5webapp.mocker.MockModel;
import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.repositories.AuthorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthorRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private AuthorRepository authorRepository;

	@Before
	public void setUp() {
		Author author = MockModel.mockAuthor_withOutIds();
		entityManager.persist(author);
		entityManager.flush();
	}

	@Test
	public void testSaveAuthor() {
		List<Author> authors = (List<Author>) authorRepository.findAll();
		assertEquals(1, authors.size());
	}

}
