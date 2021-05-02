package com.example.fishingstore.repos.order;

import com.example.fishingstore.domain.orders.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepo extends JpaRepository<ProductCart,Long> {
}
