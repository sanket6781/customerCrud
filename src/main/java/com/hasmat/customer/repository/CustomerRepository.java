package com.hasmat.customer.repository;

import com.hasmat.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    @Query(value = "SELECT * from customer_tbl WHERE is_deleted=?", nativeQuery = true)
//    public Integer isDeleted(int isDeleted);
}
