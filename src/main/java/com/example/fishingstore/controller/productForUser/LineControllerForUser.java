package com.example.fishingstore.controller.productForUser;


import com.example.fishingstore.domain.products.Line;
import com.example.fishingstore.service.order.OrderService;
import com.example.fishingstore.service.product.ServiceLine;
import com.example.fishingstore.service.order.ServiceLineCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.util.Map;

import static java.lang.Integer.parseInt;

@RequestMapping(path = "/linesUser")
@Controller
@PreAuthorize("hasAuthority('USER')")
public class LineControllerForUser {
    @Autowired
    private ServiceLine serviceLine;
    @Autowired
    private ServiceLineCart serviceLineCart;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String showAllOrFindByName(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        serviceLine.showAllOrFindByName(filter, model);
        return "/productsUser/linesforUser";
    }

    @GetMapping("{line}")
    public String lineEditForm(@PathVariable Line line, Model model) {
        return serviceLine.formForAddLine(line, model);
    }

    @PostMapping
    public String addToOrder(@RequestParam String amount,
                             @RequestParam String id,
                             @RequestParam String customer_id,
                             @RequestParam String price,
                             HttpSession session,
                             Map<String, Object> model) {
        if (session.getAttribute("orderId") == null) {
            long idU = Long.parseLong(String.valueOf(customer_id));
            orderService.addOrder(idU);
            long orderId = orderService.maxValueOrd(Long.valueOf(customer_id));
            session.setAttribute("orderId", orderId);
        }
        long id_order = Long.parseLong(String.valueOf(session.getAttribute("orderId")));
        double price_p= Double.parseDouble(price.replace(",", "."));
        long idP = Long.parseLong(id);
        int amountI = Integer.parseInt(amount);

//        if (amount > hookDao.maxValueProduct(id_product)) {
//            forward = ERR_AMOUNT;
//            req.setAttribute("max", hookDao.maxValueProduct(id_product));
//        } else {
        serviceLineCart.addToOrder(id_order, idP, amountI, price_p);
//            int currAmo = hookDao.maxValueProduct(id_product);
//            hookDao.updateAmount(amount, currAmo, id_product);
        // }
        return "redirect:/linesUser";
    }

}

