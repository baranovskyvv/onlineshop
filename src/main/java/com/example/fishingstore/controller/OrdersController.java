package com.example.fishingstore.controller;


import com.example.fishingstore.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/Orders")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/a")
    public String showActiveOrders(Model model) {
        return orderService.showAllActivityOrders(model);

    }
    @GetMapping("/d")
    public String showDeactiveOrders(Model model) {
        return orderService.showAllDeActivityOrders(model);

    }
    @GetMapping("/{id_ord}")
    public String showOrder(@PathVariable Long id_ord, Model model){
        orderService.showProductsInOrder(id_ord, model);
        return "infoAboutOrder";
    }
    @GetMapping("/deactivate/{id_ord}")
    public String deactivate(@PathVariable Long id_ord){
        orderService.deactivate(id_ord);
        return "redirect:/Orders/a";
    }
}
