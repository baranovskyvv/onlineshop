package com.example.fishingstore.service.order;


import com.example.fishingstore.domain.LittleCart;
import com.example.fishingstore.domain.orders.HookCart;
import com.example.fishingstore.domain.orders.ProductCart;
import com.example.fishingstore.repos.order.HookCartRepo;
import com.example.fishingstore.repos.order.OrderRepo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ServiceHookCart {
    @Autowired
    private HookCartRepo productCartRepo;

    public void addToOrder(long id_ord, long id_prod, int amount, double price) {
        HookCart products = new HookCart();
        products.setId_ord(id_ord);
        products.setId_prod(id_prod);
        products.setAmount(amount);
        products.setPrice(price);
        productCartRepo.save(products);
    }


}
