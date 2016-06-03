package ru.kpfu.Auto.models;

import java.util.Objects;
import javax.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "user_role")
public class UserAuthority implements GrantedAuthority{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO) 
  private Integer id;
  
  @NotBlank
  @Length(max = 30)
  @Column(length = 30, nullable = false, unique = true)
  private String authority;
  
  
 
  @Override
  public String toString(){
    return authority;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + Objects.hashCode(this.id);
    hash = 71 * hash + Objects.hashCode(this.authority);
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
    final UserAuthority other = (UserAuthority) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    if (!Objects.equals(this.authority, other.authority)) {
      return false;
    }
    return true;
  }
  
 

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

}
