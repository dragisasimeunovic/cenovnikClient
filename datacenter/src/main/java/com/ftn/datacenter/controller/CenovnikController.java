package com.ftn.datacenter.controller;

import com.ftn.datacenter.model.Cenovnik;
import com.ftn.datacenter.model.StavkaCenovnika;
import com.ftn.datacenter.model.StavkaOsiguranja;
import com.ftn.datacenter.service.CenovnikService;
import com.ftn.datacenter.service.DateService;
import com.ftn.datacenter.service.StavkaCenovnikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CenovnikController {

    @Autowired
    private CenovnikService cenovnikService;

    @Autowired
    private StavkaCenovnikaService stavkaCenovnikaService;

    @RequestMapping(
            value = "/cenovnik/save",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Cenovnik> save(@RequestBody Cenovnik c) throws ParseException {
        c.setDatumPocetka(DateService.getFormattedDateUniversal(c.getDatumPocetka()));
        Cenovnik cenovnik = cenovnikService.save(c);
        return new ResponseEntity<>(cenovnik, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/cenovnik/stavka/save/{cenovnikId}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Cenovnik> saveStavka(@RequestBody StavkaCenovnika stavka, @PathVariable Long cenovnikId) {
        Cenovnik cenovnik = cenovnikService.findOne(cenovnikId);
        stavka.setCenovnik(cenovnik);
        StavkaCenovnika stavkaCenovnika = stavkaCenovnikaService.save(stavka);
        return new ResponseEntity<>(cenovnik, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/cenovnik/aktivan",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Cenovnik> aktivan() throws ParseException {
        Cenovnik cenovnik = cenovnikService.getActive(DateService.getFormattedDateUniversal(new Date().toString()));
        return new ResponseEntity<>(cenovnik, HttpStatus.OK);
    }


}
