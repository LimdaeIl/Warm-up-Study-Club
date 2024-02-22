package com.group.libarayapp.controller.task04;

import com.group.libarayapp.dto.task04.request.Task04CreateRequest;
import com.group.libarayapp.dto.task04.request.Task04ExRequest;
import com.group.libarayapp.dto.task04.response.Task04ExResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Task04ExController {

    private final JdbcTemplate jdbcTemplate;

    public Task04ExController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 문제 1
    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody Task04ExRequest request) {
        String sql = "insert into fruit(name, warehousing, price)  values(?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }


    // 문제 2
    @PutMapping("/api/v1/fruit")
    public void salesQuantityFruit(@RequestBody Task04ExRequest request) {
        String readSql = "select * from fruit where id=?";
        boolean isSalesFruit = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isSalesFruit) {
            throw new IllegalArgumentException();
        }
        String sql = "update fruit set salesQuantity=? where id=?";
        jdbcTemplate.update(sql, request.getSalesQuantity() + 1, request.getId());
    }

    // 문제 3 - sum, group by 미적용
    @GetMapping("/api/v1/fruit/stat")
    public Task04ExResponse SalesAmountFruit(@RequestParam String name) {
        String readNotSalesSql = """
                select sum(price) as notSalesAmount
                from fruit
                where name=? and salesQuantity = 0
                group by salesQuantity;
                """;
        List<Integer> readNotSalesList = jdbcTemplate.query(readNotSalesSql, (rs, rowNum) -> rs.getInt("notSalesAmount"), name);

        String readSalesSql = """
                select sum(price) as salesAmount
                from fruit
                where name=? and salesQuantity = 1
                group by salesQuantity;
                """;
        List<Integer> readSalesList = jdbcTemplate.query(readSalesSql, (rs, rowNum) -> rs.getInt("salesAmount"), name);

        return new Task04ExResponse(readSalesList, readNotSalesList);
    }
}
