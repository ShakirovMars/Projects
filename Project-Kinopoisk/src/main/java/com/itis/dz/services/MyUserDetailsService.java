package com.itis.dz.services;

import com.itis.dz.domain.UserInfo;
import com.itis.dz.domain.UserRoles;
import com.itis.dz.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Marsel on 20.09.2016.
 */
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Transactional

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.getByEmail(email);

        if (userInfo == null)
            return new User("guest", "", true, true, true, true, new ArrayList<GrantedAuthority>());

        List<GrantedAuthority> grantedAuthorities = buildUserAuthority(userInfo.getRoles());
        return buildUserForAuthentication(userInfo, grantedAuthorities);
    }


    private User buildUserForAuthentication(UserInfo userInfo, List<GrantedAuthority> authorities) {
        return new User(userInfo.getEmail(), userInfo.getHashPass(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRoles> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build userInfo's authorities
        for (UserRoles userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<>(setAuths);
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}