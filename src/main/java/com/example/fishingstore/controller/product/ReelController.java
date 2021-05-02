package com.example.fishingstore.controller.product;



import com.example.fishingstore.domain.products.Reel;
import com.example.fishingstore.service.product.ServiceReel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path = "/reels")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class ReelController {
    @Autowired
    private ServiceReel serviceReel;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    public String showAllOrFindByName(@RequestParam(required = false, defaultValue = "")
                                              String filter, Model model) {
        return serviceReel.showAllForAdmin(filter, model);
    }

    @GetMapping("{reel}")
    public String reelEditForm(@PathVariable Reel reel, Model model) {
   return serviceReel.editFormForProduct(reel, model);

    }

    @GetMapping("/delete/{id}")
    public String reelDeleteById(@PathVariable long id) {
        return serviceReel.deleteProductById(id);
    }

    @PostMapping("/update")
    public String update(@RequestParam String id,
                         @RequestParam String name,
                         @RequestParam String manufacturer,
                         @RequestParam String amount_balls,
                         @RequestParam String price,
                         @RequestParam String currentlyamount,
//                         @RequestParam("file") MultipartFile file,
                         Map<String, Object> model) {
        return serviceReel.updateProduct(id, name, manufacturer, amount_balls, price, currentlyamount);
    }

    @PostMapping()
    public String add(
            @RequestParam String name,
            @RequestParam String manufacturer,
            @RequestParam String amount_balls,
            @RequestParam String price,
            @RequestParam String currentlyamount,
//            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) {
        return serviceReel.addNewProduct(name, manufacturer, amount_balls, price, currentlyamount);
    }


}

