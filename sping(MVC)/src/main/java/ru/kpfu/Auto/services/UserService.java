package ru.kpfu.Auto.services;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ru.kpfu.Auto.models.User;
import ru.kpfu.Auto.models.UserAuthority;
import ru.kpfu.Auto.repositories.UserAuthorityRepository;
import ru.kpfu.Auto.repositories.UserRepository;

@Service("userDetailService")

public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserAuthorityRepository userAuthorityRepo;
	

	
	 @Override
	  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
	    return userRepo.findByUsername(username);
	  }

	
	public void registerUser(User user) {
		if(userRepo.findByUsername(user.getUsername()) != null){
		      throw new DuplicateKeyException("Duplicate key - username field.");
		    }
		    user.addAuthority(userAuthorityRepo.findByAuthority("ROLE_USER"));
		    user.setPassword(passwordEncoder.encode(user.getPassword()));
		    user.setPasswordRepeat(user.getPassword());
		    userRepo.save(user);
		  
		  	}

	
	public void updateUser(User user) {
			

		Set<UserAuthority> authorities=user.getAuthorities();
		Set<UserAuthority> newAuthorities=new HashSet<>();
		Iterator<UserAuthority> itr = authorities.iterator();
		while (itr.hasNext()) {
		
			if(itr.next().toString().equals("ROLE_ADMIN")){
	        newAuthorities.add(userAuthorityRepo.findByAuthority("ROLE_USER"));
		}
			else{
				newAuthorities.add(userAuthorityRepo.findByAuthority("ROLE_ADMIN"));
				
			}
		
		}
		user.setAuthorities(newAuthorities);
	    userRepo.save(user);
	}
}
