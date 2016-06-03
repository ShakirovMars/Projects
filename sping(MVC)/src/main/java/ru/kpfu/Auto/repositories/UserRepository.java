package ru.kpfu.Auto.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.kpfu.Auto.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	public Page<User> findAll(Pageable pageable);
	public List<User>findAll();
	public  Page<User> findByUsername(String username,Pageable pageable);
	public Page<User> findByAge( Integer age,Pageable pageable);
	public User findByUsername(String username);
	
} 

