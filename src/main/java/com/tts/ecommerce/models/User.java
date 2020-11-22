package com.tts.ecommerce.models;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Map;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
    private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
    
        return null;
    }
    @Override
    public boolean isAccountNonExpired() {
    
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
    
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
   
        return true;
    }
    @Override
    public boolean isEnabled() {
   
        return true;
    }



}
