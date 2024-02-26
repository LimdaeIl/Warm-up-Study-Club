package com.group.libarayapp.controller.task06;

import com.group.libarayapp.dto.task06.request.FruitCreateRequestEx06;
import com.group.libarayapp.dto.task06.request.FruitRequestEx06;
import com.group.libarayapp.dto.task06.response.FruitResponseEx06;
import com.group.libarayapp.service.task06.FruitServiceEx06;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitControllerEx06 {

    private final FruitServiceEx06 fruitServiceEx06;

    public FruitControllerEx06(FruitServiceEx06 fruitServiceEx06) {
        this.fruitServiceEx06 = fruitServiceEx06;
    }

    // 문제 1
    @PostMapping("/api/v2/fruit")
    public void saveFruit(@RequestBody FruitRequestEx06 request) {
        fruitServiceEx06.saveFruit(request);
    }


    // 문제 2
    @PutMapping("/api/v2/fruit")
    public void salesQuantityFruit(@RequestBody FruitCreateRequestEx06 request) {
        fruitServiceEx06.salesQuantityFruit(request);
    }

    // 문제 3
    @GetMapping("/api/v2/fruit/stat")
    public FruitResponseEx06 SalesAmountFruit(@RequestParam String name) {
        return fruitServiceEx06.salesAmountFruit(name);
    }
}
