package com.hasmat.customer.repository;

import com.hasmat.customer.model.LIndustry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustryRepository extends JpaRepository<LIndustry, Integer> {
}
