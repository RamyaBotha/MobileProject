package com.wipro.mobile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orderitem_tbl")
public class OrderItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double itemTotal;

    private int quantity;

    @OneToOne
    private Mobile mobile;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

