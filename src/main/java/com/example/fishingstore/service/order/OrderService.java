package com.example.fishingstore.service.order;

import com.example.fishingstore.domain.AddressOrder;
import com.example.fishingstore.domain.ListOrder;
import com.example.fishingstore.domain.LittleCart;
import com.example.fishingstore.domain.User;
import com.example.fishingstore.domain.orders.Order;
import com.example.fishingstore.repos.UserRepo;
import com.example.fishingstore.repos.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private HookCartRepo hcr;
    @Autowired
    private LineCartRepo lcr;
    @Autowired
    private RodCartRepo rcrod;
    @Autowired
    private ReelCartRepo rcr;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private UserRepo userRepo;

    public Long maxValueOrd(Long id_customer) {
        Long id_ord = 0L;
        List list = orderRepo.findLastId(id_customer);

        if (!list.isEmpty()) {
            id_ord = (Long) list.get(0);
        }
        return id_ord;
    }

    public void addOrder(long id_user) {
        Order order = new Order();
        order.setCustomer_id(id_user);
        orderRepo.save(order);
    }


    public String showAllActivityOrders(Model model) {
        ArrayList<ListOrder> orders = (ArrayList<ListOrder>) orderRepo.findAllActiveOrders();
        model.addAttribute("orders", orders);
        return "workWithOrders";
    }


    public String showAllDeActivityOrders(Model model) {
        ArrayList<ListOrder> orders = (ArrayList<ListOrder>) orderRepo.findAllDeactiveOrders();
        model.addAttribute("orders", orders);
        return "workWithOrders";
    }

    public void showProductsInOrder(Long id_order, Model model) {
        ArrayList<LittleCart> hooks = (ArrayList<LittleCart>) hcr.findAllProductInOrder(id_order);
        ArrayList<LittleCart> lines = (ArrayList<LittleCart>) lcr.findAllProductInOrder(id_order);
        ArrayList<LittleCart> rods = (ArrayList<LittleCart>) rcrod.findAllProductInOrder(id_order);
        ArrayList<LittleCart> reels = (ArrayList<LittleCart>) rcr.findAllProductInOrder(id_order);
        AddressOrder address = addressRepo.findById(id_order).orElse(new AddressOrder());
        User user = userRepo.findAllById(orderRepo.findNameCustomerById(id_order));
        Double totalPrice = hcr.sumOfProducts(id_order).orElse(Double.valueOf(0)) +
                lcr.sumOfProducts(id_order).orElse(Double.valueOf(0)) +
                rcrod.sumOfProducts(id_order).orElse(Double.valueOf(0)) +
                rcr.sumOfProducts(id_order).orElse(Double.valueOf(0));

        model.addAttribute("user", user);
        model.addAttribute("hooks", hooks);
        model.addAttribute("reels", reels);
        model.addAttribute("lines", lines);
        model.addAttribute("rods", rods);
        model.addAttribute("address", address);
        model.addAttribute("totalPrice", totalPrice);
    }

    public void deactivate(Long id_ord) {
        orderRepo.deactivateOrder(id_ord);
    }
}
