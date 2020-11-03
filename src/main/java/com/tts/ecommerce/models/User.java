package com.tts.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Map;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;


public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
    private Long id;

	@Email(message = "Please provide a valid email")
	@NotEmpty(message = "Please provide an email")
	private String email;

	@Length(min = 3, message = "Your username must have at least 3 characters")
	@Length(max = 15, message = "Your username cannot have more than 15 characters")
	@Pattern(regexp="[^\\s]+", message="Your username cannot contain spaces")
	private String username;

	@Length(min = 5, message = "Your password must have at least 5 characters")
	private String password;
	
	@ElementCollection
	private Map<Product, Integer> cart;

	
	public User() {
	}

	public User(Long id,
			@Email(message = "Please provide a valid email") @NotEmpty(message = "Please provide an email") String email,
			@Length(min = 3, message = "Your username must have at least 3 characters") @Length(max = 15, message = "Your username cannot have more than 15 characters") @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces") String username,
			@Length(min = 5, message = "Your password must have at least 5 characters") String password,
			Map<Product, Integer> cart) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<Product, Integer> getCart() {
		return cart;
	}

	public void setCart(Map<Product, Integer> cart) {
		this.cart = cart;
	}
	

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean isEnabled() {
    // TODO Auto-generated method stub
        return true;
    }



}
