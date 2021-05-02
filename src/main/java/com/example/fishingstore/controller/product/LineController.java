package com.example.fishingstore.controller.product;


import com.example.fishingstore.domain.products.Line;
import com.example.fishingstore.service.product.ServiceLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RequestMapping(path = "/lines")
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class LineController  {
    @Autowired
    private ServiceLine serviceLine;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
       public String showAllOrFindByName(@RequestParam(required = false, defaultValue = "")
                                              String filter, Model model) {
        return serviceLine.showAllForAdmin(filter, model);
    }

    @GetMapping("{line}")
        public String productEditForm(@PathVariable Line line, Model model) {
        return serviceLine.editFormForLine(line, model);
    }

    @GetMapping("/delete/{id}")
    public String productDeleteById(@PathVariable long id) {
        return serviceLine.deleteLineById(id);
    }

    @PostMapping("/update")
    public String update(@RequestParam String id,
                         @RequestParam String name,
                         @RequestParam String manufacturer,
                         @RequestParam String length,
                         @RequestParam String diameter,
                         @RequestParam String price,
                         @RequestParam String currentlyamount,
//                         @RequestParam("file") MultipartFile file,
                         Map<String, Object> model) {
        return serviceLine.updateLine(id, name, manufacturer, length, diameter, price, currentlyamount);
    }

    @PostMapping()
    public String add(
            @RequestParam String name,
            @RequestParam String manufacturer,
            @RequestParam String length,
            @RequestParam String diameter,
            @RequestParam String price,
            @RequestParam String currentlyamount,
//            @RequestParam("file") MultipartFile file,
            Map<String, Object> model) {
        return serviceLine.addNewLine(name, manufacturer, length, diameter, price, currentlyamount);
    }


}

