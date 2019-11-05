package guru.springframwork.spring5webapp.test.unit.resources;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframwork.spring5webapp.config.security.JwtTokenUtil;
import guru.springframwork.spring5webapp.mocker.MockModel;
import guru.springframwork.spring5webapp.model.Author;
import guru.springframwork.spring5webapp.resources.AuthorResource;
import guru.springframwork.spring5webapp.services.CrudService;

@RunWith(SpringRunner.class)
//which Controller class is to be scanned and added into Spring context
//here we are narrowing down to test only the web layer (i.e. the end points) separating it from other layers
@WebMvcTest(value = AuthorResource.class)
//Run with mocked user (cannot do secure=false as it is deprecated in Spring's later versions)
@WithMockUser
public class AuthorResourceTest {

	private List<Author> authorsData = new ArrayList<>();
	private String authorsDataJSON = "";

	/// mock all the beans otherwise spring app context does not get started
	@MockBean
	private CrudService<Author, Long> crudService;

	@MockBean
	private AuthenticationEntryPoint authEntryPoint;

	@MockBean
	private UserDetailsService userDetailsService;

	@MockBean
	private JwtTokenUtil jwtTokenUtil;

	// By using MockMvc Spring Boot to isolate the web layer and load a special app
	// context so that we can test the controller
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() throws JsonProcessingException {
		authorsData.add(MockModel.mockAuthor_withIds());
		ObjectMapper objectMapper = new ObjectMapper();
		authorsDataJSON = objectMapper.writeValueAsString(authorsData);
	}

	@Test
	public void test_getAuthors() throws Exception {
		when(crudService.findAll()).thenReturn(authorsData);
		JSONAssert.assertEquals(authorsDataJSON,
				this.mockMvc.perform(get("/authors").accept(MediaType.APPLICATION_JSON)).andDo(print())
						.andExpect(status().isOk()).andReturn().getResponse().getContentAsString(),
				false);
	}
}
