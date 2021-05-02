package com.example.fishingstore.service.order;


import com.example.fishingstore.domain.orders.LineCart;
import com.example.fishingstore.domain.orders.ReelCart;
import com.example.fishingstore.repos.order.LineCartRepo;
import com.example.fishingstore.repos.order.OrderRepo;
import com.example.fishingstore.repos.order.ReelCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ServiceReelCart {
    @Autowired
    private ReelCartRepo productCartRepo;

    public void addToOrder(long id_ord, long id_prod, int amount, double price) {
        ReelCart products = new ReelCart();
        products.setId_ord(id_ord);
        products.setId_prod(id_prod);
        products.setAmount(amount);
        products.setPrice(price);
        productCartRepo.save(products);
    }
}
