package com.hasmat.customer.service;

import com.hasmat.customer.exception.ResourceAlreadyExistsException;
import com.hasmat.customer.model.LCountry;
import com.hasmat.customer.model.LIndustry;

import java.util.List;

public interface IndustryService {
    LIndustry addIndustry(LIndustry industry) throws ResourceAlreadyExistsException;

    List<LIndustry> findAllIndustry();

    LIndustry findIndustryById(int industryId);

    LIndustry updateIndustry(LIndustry industry, int industryId);
}
