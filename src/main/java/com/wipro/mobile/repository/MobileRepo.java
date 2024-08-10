package com.wipro.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wipro.mobile.entity.Mobile;
import java.util.List;

public interface MobileRepo extends JpaRepository<Mobile,Long> {

	 @Query("select o from Mobile o where o.category.categoryId = :cid")
	    List<Mobile> findMobileByCategoryId(@Param("cid")long categoryId);

	}

