package com.hasmat.customer.service.impl;

import com.hasmat.customer.exception.ResourceAlreadyExistsException;
import com.hasmat.customer.exception.ResourceNotFoundException;
import com.hasmat.customer.model.LCountry;
import com.hasmat.customer.repository.CountryRepository;
import com.hasmat.customer.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public LCountry addCountry(LCountry country) throws ResourceAlreadyExistsException {
        if(countryRepository.findById(country.getAutCountryID()).isPresent()){
            throw new ResourceAlreadyExistsException();
        }else
        country.setBitDelFlag(0);
        return countryRepository.save(country);
    }

    @Override
    public List<LCountry> findAllCountry() {
        return countryRepository.findAll();
    }

    @Override
    public LCountry findCountryById(int countryId) {
        LCountry country = countryRepository.findById(countryId).orElseThrow(()-> new ResourceNotFoundException("Country doesn't exist with the given id - " +countryId));
        return country;
    }

    @Override
    public LCountry updateCountry(LCountry country, int countryId) {
        LCountry updateCountry = countryRepository.findById(countryId).get();
        updateCountry.setVchShortText(country.getVchShortText());
        updateCountry.setVchLongText(country.getVchLongText());
        countryRepository.save(updateCountry);
        return updateCountry;
    }
}
