package com.wipro.mobile.service;

import java.util.Set;

import com.wipro.mobile.dto.MobileDTO;

public interface MobileService  {
	 MobileDTO saveMobile(MobileDTO mobileDTO);

	    Set<MobileDTO> findAllMobiles();

	    MobileDTO findMobileById(long mobileId);

	    void deleteMobile(long mobileId);

	    MobileDTO updateMobile(MobileDTO mobileDTO);


	    Set<MobileDTO> findAllMobilesByCategory(long categoryId);
	}


