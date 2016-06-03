package ru.kpfu.Auto.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.kpfu.Auto.models.Log;
import ru.kpfu.Auto.repositories.LogRepository;

@Service
public class LogService {
    @Autowired
    LogRepository logRepository;

    public void save(Log log) {
        logRepository.save(log);
    }
}
