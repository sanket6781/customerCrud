package com.hasmat.customer.controller;

import com.hasmat.customer.model.Customer;
import com.hasmat.customer.model.LCountry;
import com.hasmat.customer.model.LIndustry;
import com.hasmat.customer.repository.IndustryRepository;
import com.hasmat.customer.service.CustomerService;
import com.hasmat.customer.service.IndustryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/industry")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @Autowired
    private IndustryRepository industryRepository;

    //Add Country
    @PostMapping(value = "/add")
    public ResponseEntity<LIndustry> createIndustry(@Valid @RequestBody LIndustry industry){
        LIndustry industry1 = industryService.addIndustry(industry);
        return  ResponseEntity.status(HttpStatus.CREATED).body(industry1);
    }

    //Get All Industry
    @GetMapping(value = "/all")
    public ResponseEntity<List<LIndustry>> getAllIndustry(){
        List<LIndustry> allIndustry = industryService.findAllIndustry();
        return  ResponseEntity.ok(allIndustry);
    }

    //Get Industry By ID
    @GetMapping(value = "/{industryId}")
    public  ResponseEntity<LIndustry> getIndustryById(@PathVariable int industryId){
        LIndustry industry = industryService.findIndustryById(industryId);
        return  ResponseEntity.ok(industry);
    }

    //Delete Industry
    @DeleteMapping(value = "/delete/{industryId}")
    public  ResponseEntity<LIndustry> deleteIndustryById(@PathVariable int industryId){
        LIndustry industry1 = industryService.findIndustryById(industryId);
        industry1.setBitDelFlag(1);
        industryRepository.save(industry1);
        return  ResponseEntity.ok(industry1);
    }

    //Update Industry
    @PutMapping(value = "/update/{industryId}")
    public ResponseEntity<LIndustry> updateIndustry(@Valid @RequestBody LIndustry industry, @PathVariable int industryId){
        LIndustry updateIndustry1 = industryService.updateIndustry(industry, industryId);
        return ResponseEntity.ok(updateIndustry1);
    }
}
