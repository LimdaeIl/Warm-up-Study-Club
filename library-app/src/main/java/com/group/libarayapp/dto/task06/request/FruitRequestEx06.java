package com.group.libarayapp.dto.task06.request;

import java.time.LocalDate;

public class FruitRequestEx06 {

    private Long id;
    private String name;
    private LocalDate warehousingDate;

    private int salesQuantity;
    private Long price;

    public FruitRequestEx06(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public int getSalesQuantity() {
        return salesQuantity;
    }
}
