package com.group.libarayapp.controller.task;

import com.group.libarayapp.dto.task.request.Ex01Request;
import com.group.libarayapp.dto.task.response.Ex01Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex01Controller {

    @GetMapping("/api/v1/calc")
    public Ex01Response firstEx(Ex01Request request) {
        return new Ex01Response(request);
    }
}
