package com.wipro.mobile.entity;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import jakarta.persistence.*;

import lombok.Data;


import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mobile {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(name="mobile_name")
	    private String mobileName;

	    @Column(name="mobile_price")
	    private double mobilePrice;

	    private LocalDate mfd;

	    @Column(name="model_number")
	    private String modelNumber;

	    @Column(name="company_name")
	    private String companyName;

	    @ManyToOne
	    private Category category;

	}


