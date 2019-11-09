package guru.springframwork.spring5webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guru.springframwork.spring5webapp.model.User;

@Service
public class Spring5WebappUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	// This @Transactional annotation is very much necessary here
	// without this we get LazyInitializationException when we call user.getRoles()
	// because, user object has been detached from Hibernate session
	// that's why we should run this inside a transaction to keep the session live
	// till we get the roles other option could be making fetch = FetchType.EAGER in
	// ManyToMany annotation
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userService.findByUserName(username);
		if (user != null) {
			return getUserDetailsFromUser(user);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	private UserDetails getUserDetailsFromUser(User user) {
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true,
				true, true, true, user.getRoles());
	}

}
