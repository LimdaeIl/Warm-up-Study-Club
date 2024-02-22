package com.group.libarayapp.dto.task02.response;

import com.group.libarayapp.dto.task02.request.Ex01Request;

public class Ex01Response {

    private final int add;
    private final int minus;
    private final int multiply;


    public Ex01Response(Ex01Request ex01Request) {
        this.add = ex01Request.getNum1() + ex01Request.getNum2();
        this.minus = ex01Request.getNum1() - ex01Request.getNum2();
        this.multiply = ex01Request.getNum1() * ex01Request.getNum2();
    }

    public int getAdd() {
        return add;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }
}
