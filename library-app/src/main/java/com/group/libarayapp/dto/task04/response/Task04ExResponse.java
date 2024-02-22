package com.group.libarayapp.dto.task04.response;

import java.util.List;

public class Task04ExResponse {
    private final long salesAmount;
    private final long notSalesAmount;

    public Task04ExResponse(List<Integer> readSalesList, List<Integer> readNotSalesList) {
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
