package com.example.fishingstore.repos.order;

import com.example.fishingstore.domain.LittleCart;
import com.example.fishingstore.domain.orders.LineCart;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface LineCartRepo extends JpaRepository<LineCart,Long> {

    @Query("select NEW com.example.fishingstore.domain.LittleCart(o.id,p.name,o.price,o.amount,o.type) from Line p, LineCart o " +
            "where   o.id_ord=:id_ord and p.id=o.id_prod")
    List<LittleCart> findAllProductInOrder(@Param("id_ord")Long id_ord);

    @Query("select SUM(O.price*O.amount) as price from LineCart O " +
            "where O.id_ord= :o ")
    Optional<Double> sumOfProducts(@Param("o") Long id_ord);
}

