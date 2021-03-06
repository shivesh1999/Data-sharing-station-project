package com.project.Entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Document("Users")
public class User implements UserDetails {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private Long id;

	private String firstname;
	private String lastname;
	private String email;
	private String contact;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	private boolean locked=false;
	private boolean enabled=true;
	private ArrayList<Long> subscribers=new ArrayList<Long>();
	private ArrayList<Long> resources=new ArrayList<Long>();


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(authority);
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getEmail() {
		return email;
	}

	public String getContact() {
		return contact;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Long> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(ArrayList<Long> subscribers) {
		this.subscribers = subscribers;
	}

	public ArrayList<Long> getResources() {
		return resources;
	}

	public void setResources(ArrayList<Long> resources) {
		this.resources = resources;
	}

	public User(long id, String firstname, String lastname, String email, String contact, String password) {
		this.id=id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
}
