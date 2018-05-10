package com.ftn.datacenter.service;

import com.ftn.datacenter.model.Cenovnik;
import com.ftn.datacenter.repository.CenovnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CenovnikService {

    @Autowired
    private CenovnikRepository cenovnikRepository;

    public Cenovnik save(Cenovnik cenovnik) {
        return cenovnikRepository.save(cenovnik);
    }

    public Cenovnik findOne(Long id) {
        return cenovnikRepository.findOne(id);
    }

    public Cenovnik getActive(String danasnjiDatum) {
        ArrayList<Cenovnik> cenovnici = cenovnikRepository.findByDatumPocetkaLessThanOrderByDatumPocetkaDesc(danasnjiDatum);
        if (!cenovnici.isEmpty()){
            return cenovnici.get(0);
        }
        return null;
    }

}
