package ru.kpfu.Auto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.kpfu.Auto.models.Log;

@Repository
public interface LogRepository extends CrudRepository<Log, Integer> {
}
