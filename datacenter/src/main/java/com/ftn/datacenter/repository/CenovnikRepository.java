package com.ftn.datacenter.repository;

import com.ftn.datacenter.model.Cenovnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Collection;

public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {

    ArrayList<Cenovnik> findByDatumPocetkaLessThanOrderByDatumPocetkaDesc(String danasnjiDatum);

}
