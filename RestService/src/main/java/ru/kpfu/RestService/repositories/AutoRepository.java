package ru.kpfu.RestService.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.kpfu.RestService.models.Auto;


@Repository

public interface AutoRepository extends CrudRepository<Auto, Integer >{

} 