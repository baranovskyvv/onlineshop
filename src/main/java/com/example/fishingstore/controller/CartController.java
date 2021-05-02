package com.example.fishingstore.controller;


import com.example.fishingstore.domain.LittleCart;
import com.example.fishingstore.domain.orders.*;
import com.example.fishingstore.repos.order.*;
import com.example.fishingstore.service.ServiceCart;
import com.example.fishingstore.service.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.ArrayList;

@RequestMapping(path = "/Cart")
@Controller
@PreAuthorize("hasAuthority('USER')")
public class CartController {
    @Autowired
    private ServiceCart serviceCart;

    @GetMapping
    public String showCart(Model model, HttpSession session) {
        serviceCart.showAllInCart(model, session);
        return "cart";
    }

    @GetMapping("/changeValueForm/{id}&{type}")
    public String editHook(@PathVariable String id, @PathVariable String type, Model model) {
        long id_ord = Long.parseLong(id);
        return serviceCart.sendValueToForm(id_ord, type, model);
    }

    @GetMapping("/delete/{id}&{type}")
    public String productDeleteById(@PathVariable String id, @PathVariable String type) {
        long id_ord = Long.parseLong(id);
        serviceCart.deleteProductInOrder(id_ord, type);
        return "redirect:/Cart";
    }

    @PostMapping("/address")
    public String confirmOrder(@RequestParam String city,
                               @RequestParam String street,
                               @RequestParam String house,
                               @RequestParam String flat,
                               @RequestParam String phone,
                               HttpSession session) {
        serviceCart.addAddress(city, street, house, flat, phone, session);
        serviceCart.activatorOrder(session);
        session.removeAttribute("orderId");
        return "okOrder";
    }
}



