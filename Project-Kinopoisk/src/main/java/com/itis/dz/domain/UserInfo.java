package com.itis.dz.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Marsel on 20.09.2016.
 */

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String secondName;

    @Column
    private String email;

    @Column
    private String hashPass;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userInfo")
    Set<UserRoles> roles = new HashSet<>(0);



    public UserInfo() {
    }

    public UserInfo(String email, String firstName, String hashPass, String lastName, String secondName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.hashPass = hashPass;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashPass() {
        return hashPass;
    }

    public void setHashPass(String hashPass) {
        this.hashPass = hashPass;
    }

    public Set<UserRoles> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoles> roles) {
        this.roles = roles;
    }


}

