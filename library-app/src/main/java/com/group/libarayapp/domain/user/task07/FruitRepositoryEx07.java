package com.group.libarayapp.domain.user.task07;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FruitRepositoryEx07 extends JpaRepository<Fruit, Long> {
    Optional<Fruit> findByName(String name);
    List<Fruit> findFruitByNameAndSalesQuantityEquals(String name, int salesQuantity);
    List<Fruit> findFruitByPriceGreaterThanEqualAndSalesQuantityEquals(Long price, int salesQuantity);
    List<Fruit> findFruitByPriceLessThanEqualAndSalesQuantityEquals(Long price, int salesQuantity);
}
