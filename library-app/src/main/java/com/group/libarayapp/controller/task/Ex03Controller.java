package com.group.libarayapp.controller.task;


import com.group.libarayapp.dto.task.request.Ex03Request;
import com.group.libarayapp.dto.task.response.Ex03Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex03Controller {

    @PostMapping("/api/v1/numbers-sum")
    public int thirdEx(@RequestBody Ex03Request request) {
        Ex03Response result = new Ex03Response(request.getNumbers());
        return result.getSum();
    }
}
