package ru.kpfu.Auto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.kpfu.Auto.models.AutoDealer;


@Repository
public interface AutoDealerRepository extends CrudRepository<AutoDealer, Integer >{
	public  AutoDealer findByName (String autoDealer);

}
