package com.wipro.mobile.dto;

import java.time.LocalDate;


import lombok.Data;

@Data
public class MobileDTO {
	
	  private long id;

	   
	    private String mobileName;

	   
	    private double mobilePrice;

	    private LocalDate mfd;

	   
	    private String modelNumber;

	   
	    private String companyName;

	   
	   // private Category category;


}
