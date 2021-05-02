package com.example.fishingstore.controller.product;

import com.example.fishingstore.domain.products.Hook;
import com.example.fishingstore.domain.products.Rod;
import com.example.fishingstore.service.product.ServiceHook;
import com.example.fishingstore.service.product.ServiceRod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path = "/rods")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class RodController {
    @Autowired
    private ServiceRod serviceP;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String showAllOrFindByName(@RequestParam(required = false, defaultValue = "")
                                              String filter, Model model) {
        return serviceP.showAllForAdmin(filter, model);
    }

    @GetMapping("{rod}")
    public String EditForm(@PathVariable Rod rod, Model model) {
        return serviceP.editFormForProduct(rod, model);
    }

    @GetMapping("/delete/{id}")
    public String DeleteById(@PathVariable long id) {
        return serviceP.deleteProductById(id);
    }

    @PostMapping("/update")
    public String update(@RequestParam String id,
                         @RequestParam String name,
                         @RequestParam String manufacturer,
                         @RequestParam String length,
                         @RequestParam String testMax,
                         @RequestParam String testMin,
                         @RequestParam String price,
                         @RequestParam String currentlyamount,
//                         @RequestParam("file") MultipartFile file,
                         Map<String, Object> model) {
        return serviceP.updateProduct(id, name, manufacturer, length, testMax, testMin, price, currentlyamount);
    }

    @PostMapping()
    public String add(
            @RequestParam String name,
            @RequestParam String manufacturer,
            @RequestParam String length,
            @RequestParam String testMax,
            @RequestParam String testMin,
            @RequestParam String price,
            @RequestParam String currentlyamount,
//            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) {
        return serviceP.addNewProduct(name, manufacturer, length, testMax, testMin, price, currentlyamount);
    }


}

