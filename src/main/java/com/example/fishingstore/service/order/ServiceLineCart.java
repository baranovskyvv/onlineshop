package com.example.fishingstore.service.order;

import com.example.fishingstore.domain.orders.LineCart;
import com.example.fishingstore.repos.order.LineCartRepo;
import com.example.fishingstore.repos.order.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ServiceLineCart {
    @Autowired
   private LineCartRepo productCartRepo;

    public void addToOrder(long id_ord, long id_prod, int amount, double price) {
        LineCart products = new LineCart();
        products.setId_ord(id_ord);
        products.setId_prod(id_prod);
        products.setAmount(amount);
        products.setPrice(price);
        productCartRepo.save(products);
    }
}
