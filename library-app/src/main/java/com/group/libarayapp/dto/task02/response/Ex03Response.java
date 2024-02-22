package com.group.libarayapp.dto.task02.response;

import java.util.List;

public class Ex03Response {
    private int sum;

    public Ex03Response(List<Integer> numbers) {
        for (int number : numbers) {
            sum += number;
        }
    }

    public int getSum() {
        return sum;
    }
}
