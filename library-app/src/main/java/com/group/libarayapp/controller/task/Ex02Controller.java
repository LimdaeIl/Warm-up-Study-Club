package com.group.libarayapp.controller.task;

import com.group.libarayapp.dto.task.request.Ex02Request;
import com.group.libarayapp.dto.task.response.Ex02Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex02Controller {

    @GetMapping("/api/v1/day-of-the-week")
    public Ex02Response secondEx(Ex02Request request) {
        return new Ex02Response(request);
    }
}
