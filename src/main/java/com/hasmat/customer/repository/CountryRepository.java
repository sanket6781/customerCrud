package com.hasmat.customer.repository;

import com.hasmat.customer.model.LCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<LCountry, Integer> {
}
