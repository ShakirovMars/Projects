package ru.kpfu.RestService.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.kpfu.RestService.exceptions.NotFoundException;
import ru.kpfu.RestService.models.Auto;
import ru.kpfu.RestService.repositories.AutoRepository;



@Service

public class AutoService {

	@Autowired
	private AutoRepository autoRepo;


    public void delete(Integer id) {
       
        	autoRepo.delete(id);
      
    }

    public void save(Auto auto) {
    	autoRepo.save(auto);
    }

    public List<Auto> findAll() {
        List<Auto> cars = (List<Auto>) autoRepo.findAll();
        if (cars == null || cars.isEmpty()) {
        	 throw new NotFoundException("auto");
        }
        return cars;
    }

    public Auto findOne(Integer id) {
        Auto auto = autoRepo.findOne(id);
        if (auto == null) {
            throw new NotFoundException("auto");
        }

        return auto;
    }

    public void update( int id, String model, int yearAuto, int cost, String typeAuto) {
    	
    	 Auto auto=autoRepo.findOne(id);
		    if(auto!=null){
		    	auto.setCost(cost);
		    	auto.setModel(model);
		    	auto.setTypeAuto(typeAuto);
		    	auto.setYearAuto(yearAuto);
		    }
    	
    	
    	autoRepo.save(auto);
    }
	
	
}
