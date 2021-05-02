package com.example.fishingstore.controller.product;

import com.example.fishingstore.domain.products.Hook;
import com.example.fishingstore.service.product.ServiceHook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RequestMapping(path = "/hooks")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class HookController {

    @Autowired
    private ServiceHook serviceP;
//    @Value("${upload.path}")
//    private String uploadPath;

    @GetMapping
    public String showAllOrFindByName(@RequestParam(required = false, defaultValue = "")
                                              String filter, Model model) {
        return serviceP.showAllForAdmin(filter, model);
    }

    @GetMapping("{hook}")
    public String hookEditForm(@PathVariable Hook hook, Model model) {
        return serviceP.editFormForProduct(hook, model);

    }

    @GetMapping("/delete/{id}")
    public String hookDeleteById(@PathVariable long id) {
        return serviceP.deleteProductById(id);
    }

    @PostMapping("/update")
    public String update(@RequestParam String id,
                         @RequestParam String name,
                         @RequestParam String manufacturer,
                         @RequestParam String size,
                         @RequestParam String price,
                         @RequestParam String currentlyamount,
//                         @RequestParam("file") MultipartFile file,
                         Map<String, Object> model) {
        return serviceP.updateProduct(id, name, manufacturer, size, price, currentlyamount);
    }

    @PostMapping()
    public String add(
            @RequestParam String name,
            @RequestParam String manufacturer,
            @RequestParam String size,
            @RequestParam String price,
            @RequestParam String currentlyamount
) {
        return serviceP.addNewProduct(name, manufacturer, size, price, currentlyamount);
    }


}

