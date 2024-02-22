package com.group.libarayapp.dto.task04.response;

public class Task04ExResponse {
    private long salesAmount;
    private long notSalesAmount;

    public Task04ExResponse(long salesAmount, long notSalesAmount) {
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
