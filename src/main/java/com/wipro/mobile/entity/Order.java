package com.wipro.mobile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_tbl")
public class Order {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(name="order_amount")
	    private double orderAmount;

	    @Column(name="order_date")
	    private LocalDate orderDate;

	    @Column(name="order_status")
	    private String orderStatus;

	    @OneToMany(mappedBy = "order")
	    private Set<OrderItem> orderItems;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

//	    @ManyToOne
//	    @JoinColumn(name = "customer_id")
//	    private Customer customer;

}
