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

    private final List<Task04CreateRequest> Task04CreateRequestList = new ArrayList<>();
    long salesSum = 0;
    long notSalesSum = 0;

    // 문제 3 - sum, group by 미적용
    @GetMapping("/api/v1/fruit/stat")
    public Task04ExResponse SalesAmountFruit(@RequestParam String name) {

        // 모든 값을 List 에 저장
        String readSql = "select * from fruit";
        jdbcTemplate.query(readSql, (rs, rowNum) -> {
            Task04CreateRequest createRequest = new Task04CreateRequest(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getDate("warehousing").toLocalDate(),
                    rs.getLong("price"),
                    rs.getInt("salesQuantity"));
            Task04CreateRequestList.add(createRequest);

            return createRequest;
        });

        // 판매된 상품과 판매되지 않은 상품의 가격을 반환
        for (Task04CreateRequest task04CreateRequest : Task04CreateRequestList) {
            if (task04CreateRequest.getName().equals(name)) {
                if (task04CreateRequest.getSalesQuantity() > 0) {
                    salesSum += task04CreateRequest.getSalesQuantity() * task04CreateRequest.getPrice();
                } else {
                    notSalesSum += task04CreateRequest.getPrice();
                }
            }
        }
        return new Task04ExResponse(salesSum, notSalesSum);
    }
}