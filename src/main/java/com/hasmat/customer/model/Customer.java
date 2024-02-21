package com.hasmat.customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_tbl")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int autCustomerID;

    @Column(name = "industry_id")
    private int industryID;

    @Column(name = "customer_name")
    @NotNull(message="Name Cannot Be Empty")
    @Size(max = 15, message = "Name cannot be more than 50 characters.")
    private String vchCustomerName;

    @Column(name = "customer_short_name")
    @NotNull(message="Short Name Cannot Be Empty")
    @Size(max = 15, message = "Short Name cannot be more than 15 characters.")
    private String vchShortText;

    @Column(name = "customer_address_one")
    @Size(max = 15, message = "Address 1 cannot be more than 50 characters.")
    private String vchAddress1;

    @Column(name = "customer_address_two")
    @Size(max = 15, message = "Address 2 cannot be more than 50 characters.")
    private String vchAddress2;

    @Column(name = "customer_address_street")
    @Size(max = 15, message = "Street Name cannot be more than 50 characters.")
    private String vchStreet;

    @Column(name="customer_country_code")
    @Min(value=3, message = "Country Code cannot be less than 3 characters.")
    private int countryID;

    @Column(name = "customer_zip_code")
    @Size(max=15, message = "Zip code cannot be more than 15 characters")
    private String vchZip;

    @Column(name = "customer_city")
    @Size(max=50, message = "City cannot be more than 50 characters ")
    private String vchCity;

    @Column(name = "customer_phone")
    @Size(max=50, message = "Phone number cannot be more than 20 characters ")
    private String vchPhone;

    @Column(name = "customer_fax")
    @Size(max=50, message = "Fax cannot be more than 20 characters ")
    private String vchFax;

    @Column(name = "customer_website")
    @Size(max=50, message = "Website cannot be more than 50 characters ")
    private String vchWebsite;

    @Column(name = "customer_email")
    @Size(max=50, message = "Email cannot be more than 50 characters ")
    @Email(message = "Email Id Not Valid.")
    private String vchEmail;

    @Column(name = "customer_comments")
    private String vchComments;

    @Column(name = "is_deleted")
    private int bitDelFlag;
}
