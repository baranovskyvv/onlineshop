package com.example.fishingstore.service;

import com.example.fishingstore.domain.AddressOrder;
import com.example.fishingstore.domain.ListOrder;
import com.example.fishingstore.domain.LittleCart;
import com.example.fishingstore.domain.orders.HookCart;
import com.example.fishingstore.repos.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.*;

@Service
public class ServiceCart {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private HookCartRepo hcr;
    @Autowired
    private LineCartRepo lcr;
    @Autowired
    private RodCartRepo rcrod;
    @Autowired
    private ReelCartRepo rcr;
    @Autowired
    private  OrderRepo orderRepo;


    public void showAllInCart(Model model, HttpSession session) {
        Long id_order = Long.parseLong(String.valueOf(session.getAttribute("orderId")));
        ArrayList<LittleCart> hooks = (ArrayList<LittleCart>) hcr.findAllProductInOrder(id_order);
        ArrayList<LittleCart> lines = (ArrayList<LittleCart>) lcr.findAllProductInOrder(id_order);
        ArrayList<LittleCart> rods = (ArrayList<LittleCart>) rcrod.findAllProductInOrder(id_order);
        ArrayList<LittleCart> reels = (ArrayList<LittleCart>) rcr.findAllProductInOrder(id_order);
        Double totalPrice = hcr.sumOfProducts(id_order).orElse(Double.valueOf(0)) +
                lcr.sumOfProducts(id_order).orElse(Double.valueOf(0)) +
                rcrod.sumOfProducts(id_order).orElse(Double.valueOf(0)) +
                rcr.sumOfProducts(id_order).orElse(Double.valueOf(0));
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("hooks", hooks);
        model.addAttribute("reels", reels);
        model.addAttribute("lines", lines);
        model.addAttribute("rods", rods);

    }


    public String deleteProductInOrder(Long id, String type) {
        if (type == "hook" || type.equals("hook")) {
            hcr.deleteById(id);
        } else if (type == "line" || type.equals("line")) {
            lcr.deleteById(id);
        } else if (type == "reel" || type.equals("reel")) {
            rcr.deleteById(id);
        } else if (type == "rod" || type.equals("rod")) {
            rcrod.deleteById(id);
        }
        return "redirect:/cart";
    }

    public String sendValueToForm(Long id, String type, Model model) {
        if (type == "hook" || type.equals("hook")) {
            List<HookCart> hook = hcr.findAllById(id);
            model.addAttribute("hook", hook);
        } else if (type == "line" || type.equals("line")) {
            lcr.deleteById(id);
        } else if (type == "reel" || type.equals("reel")) {
            rcr.deleteById(id);
        } else if (type == "rod" || type.equals("rod")) {
            rcrod.deleteById(id);
        }
        return "productsUser/editForm";
    }

    public void addAddress(String city, String street, String house, String flat, String phone, HttpSession httpSession) {
        AddressOrder addressOrder = new AddressOrder();
        Long id = (Long) httpSession.getAttribute("orderId");
        addressOrder.setId(id);
        addressOrder.setCity(city);
        addressOrder.setStreet(street);
        addressOrder.setHouse(house);
        addressOrder.setFlat(flat);
        addressOrder.setPhone(phone);
        addressRepo.save(addressOrder);
    }


    public void activatorOrder(HttpSession session) {
        long id_order = Long.parseLong(String.valueOf(session.getAttribute("orderId")));
        orderRepo.activatorOrder(id_order);

    }
}
