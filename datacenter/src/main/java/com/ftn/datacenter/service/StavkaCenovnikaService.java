package com.ftn.datacenter.service;

import com.ftn.datacenter.model.StavkaCenovnika;
import com.ftn.datacenter.repository.StavkaCenovnikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StavkaCenovnikaService {

    @Autowired
    private StavkaCenovnikaRepository stavkaCenovnikaRepository;

    public StavkaCenovnika save(StavkaCenovnika stavkaCenovnika) {
        return stavkaCenovnikaRepository.save(stavkaCenovnika);
    }



}
