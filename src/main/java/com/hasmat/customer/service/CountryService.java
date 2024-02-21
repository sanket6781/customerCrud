package com.hasmat.customer.service;

import com.hasmat.customer.exception.ResourceAlreadyExistsException;
import com.hasmat.customer.model.LCountry;

import java.util.List;

public interface CountryService {
        LCountry addCountry(LCountry country) throws ResourceAlreadyExistsException;

        List<LCountry> findAllCountry();

        LCountry findCountryById(int countryId);

        LCountry updateCountry(LCountry country,int countryId);
        }
