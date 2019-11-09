package guru.springframwork.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserLogin")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String userName;
	private String password;
	private boolean active;

	@ManyToMany
	@JoinTable(name = "userlogin_userrole", joinColumns = @JoinColumn(name = "UserRole_id"), inverseJoinColumns = @JoinColumn(name = "UserLogin_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
		super();
	}

	public User(long id, String userName, String password, boolean active) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", userName=" + userName + ", password=" + password + ", active=" + active + "]";
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
