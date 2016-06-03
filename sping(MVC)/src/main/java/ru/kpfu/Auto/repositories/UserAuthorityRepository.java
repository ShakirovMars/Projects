package ru.kpfu.Auto.repositories;

import org.springframework.data.repository.CrudRepository;

import ru.kpfu.Auto.models.UserAuthority;

public interface UserAuthorityRepository extends CrudRepository<UserAuthority, Integer> {

  public UserAuthority findByAuthority(String role_user);
}
