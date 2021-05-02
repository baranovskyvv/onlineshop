package com.example.fishingstore.repos.order;

import com.example.fishingstore.domain.LittleCart;
import com.example.fishingstore.domain.orders.HookCart;
import com.example.fishingstore.domain.orders.LineCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface HookCartRepo extends JpaRepository<HookCart, Long> {

    @Query("select NEW com.example.fishingstore.domain.LittleCart(o.id,p.name,o.price,o.amount,o.type) from Hook p, HookCart o " +
            "where   o.id_ord=:id_ord and p.id=o.id_prod")
    List<LittleCart> findAllProductInOrder(@Param("id_ord") Long id_ord);

    @Query("from HookCart where id=:id")
    List<HookCart> findAllById(@Param("id") Long id);

    @Query("select SUM(O.price*O.amount) as price from HookCart O where O.id_ord= :o")
    Optional<Double> sumOfProducts(@Param("o") Long id_ord);
}

