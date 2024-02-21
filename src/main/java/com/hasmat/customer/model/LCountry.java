package com.hasmat.customer.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country_tbl")
public class LCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private int autCountryID;

    @Column(name = "country_short_description")
    @Size(max=5, message="Short text cannot be more than 5 characters")
    private String vchShortText;

    @Column(name = "country_long_description")
    @Size(max=25, message="Long text cannot be more than 25 characters")
    private String vchLongText;

    @Column(name = "is_deleted")
    private int bitDelFlag;
}
