package com.project.Entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
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


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(userRole.name());
		return Collections.singletonList(authority);
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


	public User(long id,String firstname, String lastname, String email, String contact, String password) {
		this.id=id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
}
