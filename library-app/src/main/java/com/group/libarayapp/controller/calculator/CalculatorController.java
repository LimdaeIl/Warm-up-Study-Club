package com.group.libarayapp.controller.calculator;

import com.group.libarayapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libarayapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    /**
     * http://localhost:8080/add?number1=100&number2=200
     *
     * @param number1 요청 파라미터
     * @param number2 요청 파라미터
     * @apiNote @RequestParam 이란, HTTP 요청에서 파라미터를 추출하는 데 사용되는 어노테이션
     */
    @GetMapping("/add") // GET /add
    public int addTwoNumbers(
            @RequestParam int number1,
            @RequestParam int number2
    ) {
        return number1 + number2;
    }

    /**
     * http://localhost:8080/add-request?number1=100&number2=200
     *
     * @param request @RequestParam 을 제거하고 객체를 요청 파라미터로 보낼 수 있다.
     * @return 객체의 getter 메서드로 접근하여 두 필드의 값을 더한다.
     */
    @GetMapping("/add-request") // GET /add
    public int addTwoNumbersRequest(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply") // POST /multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
}
