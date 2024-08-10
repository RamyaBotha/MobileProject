package com.wipro.mobile.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int categoryId;

	    @Column(name="category_name")
	    private String categoryName;

	    @OneToMany(mappedBy ="category")
	    private List<Mobile> mobilelist;
	}


