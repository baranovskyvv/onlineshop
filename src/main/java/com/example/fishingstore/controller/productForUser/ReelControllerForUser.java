package com.example.fishingstore.controller.productForUser;



import com.example.fishingstore.domain.products.Reel;
import com.example.fishingstore.service.order.OrderService;
import com.example.fishingstore.service.order.ServiceReelCart;
import com.example.fishingstore.service.product.ServiceReel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequestMapping(path = "/reelsUser")
@Controller
@PreAuthorize("hasAuthority('USER')")
public class ReelControllerForUser {
    @Autowired
    private ServiceReel serviceP;
    @Autowired
    private ServiceReelCart serviceC;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showAllOrFindByName(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        serviceP.showAllforUser(filter, model);
        return "/productsUser/reelsforUser";
    }

    @GetMapping("{reel}")
    public String productEditForm(@PathVariable Reel reel, Model model) {
        return serviceP.formForAddProduct(reel, model);
    }

    @PostMapping
    public String addToOrder(@RequestParam String amount,
                             @RequestParam String id,
                             @RequestParam String customer_id,
                             @RequestParam String price,
                             HttpSession session) {
        if (session.getAttribute("orderId") == null) {
            long idU = Long.parseLong(String.valueOf(customer_id));
            orderService.addOrder(idU);
            long orderId = orderService.maxValueOrd(Long.valueOf(customer_id));
            session.setAttribute("orderId", orderId);
        }
        long id_order = Long.parseLong(String.valueOf(session.getAttribute("orderId")));

        long idP = Long.parseLong(id);
        int amountI = Integer.parseInt(amount);
        double price_p= Double.parseDouble(price.replace(",", "."));
//        if (amount > hookDao.maxValueProduct(id_product)) {
//            forward = ERR_AMOUNT;
//            req.setAttribute("max", hookDao.maxValueProduct(id_product));
//        } else {
        serviceC.addToOrder(id_order, idP, amountI, price_p);
//            int currAmo = hookDao.maxValueProduct(id_product);
//            hookDao.updateAmount(amount, currAmo, id_product);
        // }
        return "redirect:/reelsUser";
    }

}

