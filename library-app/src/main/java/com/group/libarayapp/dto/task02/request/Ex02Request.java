package com.group.libarayapp.dto.task02.request;

import java.time.LocalDate;

public class Ex02Request {

    private final LocalDate date;

    public Ex02Request(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
