package com.hasmat.customer.service.impl;

import com.hasmat.customer.exception.ResourceAlreadyExistsException;
import com.hasmat.customer.exception.ResourceNotFoundException;
import com.hasmat.customer.model.LCountry;
import com.hasmat.customer.model.LIndustry;
import com.hasmat.customer.repository.IndustryRepository;
import com.hasmat.customer.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    IndustryRepository industryRepository;

    @Override
    public LIndustry addIndustry(LIndustry industry) throws ResourceAlreadyExistsException {
        if(industryRepository.findById(industry.getAutIndustryID()).isPresent()){
            throw new ResourceAlreadyExistsException();
        }else
        industry.setBitDelFlag(0);
        return industryRepository.save(industry);
    }

    @Override
    public List<LIndustry> findAllIndustry() {
        return industryRepository.findAll();
    }

    @Override
    public LIndustry findIndustryById(int industryId) {
        LIndustry industry = industryRepository.findById(industryId).orElseThrow(()-> new ResourceNotFoundException("Industry doesn't exist with the given id - " +industryId));
        return industry;
    }

    @Override
    public LIndustry updateIndustry(LIndustry industry, int industryId) {
        LIndustry updateIndustry = industryRepository.findById(industryId).get();
        updateIndustry.setVchShortText(industry.getVchShortText());
        updateIndustry.setVchLongText(industry.getVchLongText());
        industryRepository.save(updateIndustry);
        return updateIndustry;
    }
}
