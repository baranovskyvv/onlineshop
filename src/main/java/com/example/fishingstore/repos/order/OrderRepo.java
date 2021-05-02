package com.example.fishingstore.repos.order;

import com.example.fishingstore.domain.orders.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query("select id from Order  where customer_id=?1 order by id desc")
    List findLastId(Long id_customer);

    @Query("select NEW com.example.fishingstore.domain.ListOrder(o.id,p.username,o.active) from Order o, User p " +
            "where o.active='true' and o.customer_id=p.id")
    List findAllActiveOrders();

    @Query("select NEW com.example.fishingstore.domain.ListOrder(o.id,p.username,o.active) from Order o, User p " +
            "where o.active='false' and o.customer_id=p.id")
    List findAllDeactiveOrders();

    @Query("select customer_id from Order where id=?1")
    Long findNameCustomerById(Long orderId);

    @Modifying
    @Transactional
    @Query("update Order set active='false' WHERE id=?1 ")
    void deactivateOrder(Long id);

    @Modifying
    @Transactional
    @Query("update Order set active='true' WHERE id=?1 ")
    void activatorOrder(Long id);
}
