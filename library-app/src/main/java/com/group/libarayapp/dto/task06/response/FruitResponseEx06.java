package com.group.libarayapp.dto.task06.response;

import java.util.List;

public class FruitResponseEx06 {
    private final long salesAmount;
    private final long notSalesAmount;

    public FruitResponseEx06(List<Integer> readSalesList, List<Integer> readNotSalesList) {
        this.salesAmount = readSalesList.get(0);
        this.notSalesAmount = readNotSalesList.get(0);
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}
