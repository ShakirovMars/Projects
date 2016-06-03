package ru.kpfu.Auto.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.kpfu.Auto.models.AddressAutoDealer;
import ru.kpfu.Auto.models.Auto;
import ru.kpfu.Auto.models.AutoDealer;

@Repository
public interface AddressAutoDealerRepository extends CrudRepository<AddressAutoDealer, Integer > {
	public List<Auto> findByAutoDealerId(AutoDealer autoDealer);

}
