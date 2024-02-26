package com.group.libarayapp.repository.task06;

import com.group.libarayapp.dto.task06.request.FruitCreateRequestEx06;
import com.group.libarayapp.dto.task06.request.FruitRequestEx06;
import com.group.libarayapp.dto.task06.response.FruitResponseEx06;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Primary
@Repository
public class FruitMySqlRepositoryEx06 implements FruitRepositoryEx06 {

    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepositoryEx06(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruit(FruitRequestEx06 request) {
        String sql = "insert into fruit(name, warehousing, price)  values(?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @Override
    public boolean isSalesFruitNotExist(FruitCreateRequestEx06 request) {
        String readSql = "select * from fruit where id=?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
    }

    @Override
    public void salesQuantityFruit(FruitCreateRequestEx06 request) {
        String sql = "update fruit set salesQuantity=? where id=?";
        jdbcTemplate.update(sql, request.getSalesQuantity() + 1, request.getId());
    }

    @Override
    public FruitResponseEx06 salesAmountFruit(String name) {
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

        return new FruitResponseEx06(readSalesList, readNotSalesList);

    }
}
