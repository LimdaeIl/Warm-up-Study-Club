package com.group.libarayapp.dto.task07.response;

public class FruitResponseEx07 {
    private final long salesAmount;
    private final long notSalesAmount;

    public FruitResponseEx07(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
