package com.hasmat.customer.controller;

import com.hasmat.customer.model.Customer;
import com.hasmat.customer.model.LCountry;
import com.hasmat.customer.repository.CountryRepository;
import com.hasmat.customer.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryRepository countryRepository;

    //Add Country
    @PostMapping(value = "/add")
    public ResponseEntity<LCountry> createCountry(  @RequestBody LCountry country){
        LCountry country1 = countryService.addCountry(country);
        return  ResponseEntity.status(HttpStatus.CREATED).body(country1);
    }

    //Get All Country
    @GetMapping(value = "/all")
    public ResponseEntity<List<LCountry>> getAllCountry(){
        List<LCountry> allCountry = countryService.findAllCountry();
        return  ResponseEntity.ok(allCountry);
    }

    //Get Country By ID
    @GetMapping(value = "/{countryId}")
    public  ResponseEntity<LCountry> getCountryById(@PathVariable int countryId){
        LCountry country = countryService.findCountryById(countryId);
        return  ResponseEntity.ok(country);
    }

    //Delete Country
    @DeleteMapping(value = "/delete/{countryId}")
    public  ResponseEntity<LCountry> deleteCountryById(@PathVariable int countryId){
        LCountry country1 = countryService.findCountryById(countryId);
        country1.setBitDelFlag(1);
        countryRepository.save(country1);
        return  ResponseEntity.ok(country1);
    }

    //Update Country
    @PutMapping(value = "/update/{countryId}")
    public ResponseEntity<LCountry> updateCountry(@Valid @RequestBody LCountry country, @PathVariable int countryId){
        LCountry updateCountry1 = countryService.updateCountry(country, countryId);
        return ResponseEntity.ok(updateCountry1);
    }
}
