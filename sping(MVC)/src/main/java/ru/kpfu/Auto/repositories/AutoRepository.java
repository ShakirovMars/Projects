package ru.kpfu.Auto.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.kpfu.Auto.models.Auto;
import ru.kpfu.Auto.models.User;




@Repository

public interface AutoRepository extends CrudRepository<Auto, Integer >{

	public  Page<Auto> findAll(Pageable pageable);
	public  Page<Auto> findByModel(String model,Pageable pageable);
	public Page<Auto> findByCost(Integer cost,Pageable pageable);
	public  List<Auto> findAll();
     public Page<Auto> findByUser(User user,Pageable pageable);
	public List<Auto> findByUser(User user);
} 