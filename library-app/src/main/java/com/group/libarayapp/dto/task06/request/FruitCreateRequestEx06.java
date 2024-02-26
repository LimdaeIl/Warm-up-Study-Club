package com.group.libarayapp.dto.task06.request;

import java.time.LocalDate;

public class FruitCreateRequestEx06 {

    Long id;
    String name;
    LocalDate warehousing;
    Long price;
    int salesQuantity;

    public FruitCreateRequestEx06(Long id, String name, LocalDate warehousing, Long price, int salesQuantity) {
        this.id = id;
        this.name = name;
        this.warehousing = warehousing;
        this.price = price;
        this.salesQuantity = salesQuantity;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
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
}
