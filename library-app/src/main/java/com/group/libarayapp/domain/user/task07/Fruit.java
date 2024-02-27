package com.group.libarayapp.domain.user.task07;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Fruit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false)
    private LocalDate warehousing;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private int salesQuantity;



    protected Fruit() {}

    public Fruit(String name, LocalDate warehousing, Long price, int salesQuantity) {
        this.name = name;
        this.warehousing = warehousing;
        this.price = price;
        this.salesQuantity = salesQuantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousing() {
        return warehousing;
    }

    public Long getPrice() {
        return price;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }

    public void updateSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }
}
