package com.example.fishingstore.service.product;


import com.example.fishingstore.domain.LittleCart;
import com.example.fishingstore.domain.products.Hook;
import com.example.fishingstore.domain.products.Reel;
import com.example.fishingstore.repos.product.HookRepo;
import com.example.fishingstore.repos.product.ReelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ServiceHook {
    @Autowired
    private HookRepo productRepo;
    @Value("${upload.path}")
    private String uploadPath;

    public void showAllforUser (@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Hook> hooks = productRepo.findAllProductforUser();
        if (filter != null && !filter.isEmpty()) {
            hooks = productRepo.findByName(filter);
        } else {
            hooks = productRepo.findAllProductforUser();
        }
          model.addAttribute("hooks", hooks);
        model.addAttribute("filter", filter);
    }
    public String showAllForAdmin(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Hook> hooks = productRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            hooks = productRepo.findByName(filter);
        } else {
            hooks = productRepo.findAll();
        }
        model.addAttribute("hooks", hooks);
        model.addAttribute("filter", filter);
        return "/productsAdmin/hooks";
    }

    public String addNewProduct(@RequestParam String name,
                                @RequestParam String manufacturer,
                                @RequestParam String size,
                                @RequestParam String price,
                                @RequestParam String currentlyamount)
//                             @RequestParam("file") MultipartFile file) throws IOException
    {
        Hook product = new Hook();
        product.setManufacturer(manufacturer);
        product.setName(name);
        product.setSize(Integer.valueOf(size));
        product.setCurrentlyamount(Integer.valueOf(currentlyamount));
        product.setPrice(Double.valueOf(price));
//        if (file != null && !file.getOriginalFilename().isEmpty()) {
//                    File uploadDir = new File(uploadPath);
//
//                    if (!uploadDir.exists()) {
//                        uploadDir.mkdir();
//            }
//
//            String uuidFile = UUID.randomUUID().toString();
//            String resultFilename = uuidFile + "." + file.getOriginalFilename();
//
//            file.transferTo(new File(uploadPath + "/" + resultFilename));
//
//            line.setFilename(resultFilename);
//        }
        productRepo.save(product);

        return "redirect:/hooks";
    }


    public String updateProduct(@RequestParam String id,
                                @RequestParam String name,
                                @RequestParam String manufacturer,
                                @RequestParam String size,
                                @RequestParam String price,
                                @RequestParam String currentlyamount)
//                             @RequestParam("file") MultipartFile file) throws IOException
    {
        Hook product = new Hook();
        product.setId(Long.valueOf(id));
        product.setManufacturer(manufacturer);
        product.setName(name);
        product.setSize(Integer.valueOf(size));
        product.setCurrentlyamount(Integer.valueOf(currentlyamount.replace(" ", "")));
        product.setPrice(Double.valueOf(price.replace(" ", "").replace(",", ".")));

//        if (file != null && !file.getOriginalFilename().isEmpty()) {
//            File uploadDir = new File(uploadPath);
//
//            if (!uploadDir.exists()) {
//                uploadDir.mkdir();
//            }
//
//            String uuidFile = UUID.randomUUID().toString();
//            String resultFilename = uuidFile + "." + file.getOriginalFilename();
//
//            file.transferTo(new File(uploadPath + "/" + resultFilename));
//
//            line.setFilename(resultFilename);
//        }
        productRepo.save(product);
        return "redirect:/hooks";
    }

    public String deleteProductById(@PathVariable long id) {
        productRepo.deleteById(id);
        return "redirect:/hooks";
    }

    public String editFormForProduct(@PathVariable Hook hook, Model model) {
        model.addAttribute("hook", hook);
        return "/productsAdmin/hookEdit";
    }

    public String formForAddProduct(@PathVariable Hook hook, Model model) {
        model.addAttribute("hook", hook);
        return "/productsUser/addHookToOrder";
    }



   }



