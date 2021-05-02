package com.example.fishingstore.service.order;


import com.example.fishingstore.domain.orders.HookCart;
import com.example.fishingstore.domain.orders.RodCart;
import com.example.fishingstore.repos.order.HookCartRepo;
import com.example.fishingstore.repos.order.OrderRepo;
import com.example.fishingstore.repos.order.RodCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ServiceRodCart {
    @Autowired
    private RodCartRepo productCartRepo;

    public void addToOrder(long id_ord, long id_prod, int amount, double price) {
        RodCart products = new RodCart();
        products.setId_ord(id_ord);
        products.setId_prod(id_prod);
        products.setAmount(amount);
        products.setPrice(price);
        productCartRepo.save(products);
    }

}
