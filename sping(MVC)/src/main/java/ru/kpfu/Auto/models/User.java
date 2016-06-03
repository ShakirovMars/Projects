package ru.kpfu.Auto.models;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;


@DynamicUpdate
@Entity
@Table(name = "users")

public class User implements CredentialsContainer, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer  id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Transient
	private String passwordRepeat;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	@JoinTable(name = "user_user_role", joinColumns = @JoinColumn(name = "user"), inverseJoinColumns = @JoinColumn(name = "user_role"))
	private Set<UserAuthority> authorities = new HashSet<>();

	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "fullName", nullable = false)
	private String fullName;
	
	

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = { CascadeType.MERGE })
	  private List<Auto> cars;
	  
	
      public List<Auto> getCars() {
		return cars;
	}

	public void setCars(List<Auto> cars) {
		this.cars = cars;
	}


	public User() {
	}

	public User(String username, String fullName, String password, int age, Set<UserAuthority> authorities) {
		this.username = username;
		this.fullName = fullName;
		this.password = password;
		this.age = age;
		this.authorities = authorities;

	}

	@Override
	public void eraseCredentials() {
		this.password = null;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 19 * hash + Objects.hashCode(this.id);
		hash = 19 * hash + Objects.hashCode(this.username);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.username, other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.fullName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addAuthority(UserAuthority authority) {
		this.authorities.add(authority);
	}

	@Override
	public Set<UserAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
