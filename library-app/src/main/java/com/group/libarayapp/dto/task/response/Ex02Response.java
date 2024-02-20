package com.group.libarayapp.dto.task.response;

import com.group.libarayapp.dto.task.request.Ex02Request;

import java.time.format.TextStyle;
import java.util.Locale;

public class Ex02Response {

    private final String dayOfTheWeek;

    public Ex02Response(Ex02Request request) {
        this.dayOfTheWeek = request.getDate().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase();
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }
}
