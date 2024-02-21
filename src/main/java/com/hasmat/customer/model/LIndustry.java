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
@Table(name = "industry_tbl")
public class LIndustry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "industry_id")
    private int autIndustryID;

    @Column(name = "industry_short_description")
    @Size(max=5, message="Short description cannot be more than 5 characters")
    private String vchShortText;

    @Column(name = "industry_long_description")
    @Size(max=25, message="Long Description cannot be more than 25 characters")
    private String vchLongText;

    @Column(name = "is_deleted")
    private int bitDelFlag;
}
