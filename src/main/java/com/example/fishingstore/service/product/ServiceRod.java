package com.example.fishingstore.service.product;


import com.example.fishingstore.domain.products.Hook;
import com.example.fishingstore.domain.products.Rod;
import com.example.fishingstore.repos.product.HookRepo;
import com.example.fishingstore.repos.product.RodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ServiceRod {
    @Autowired
    private RodRepo productRepo;
    @Value("${upload.path}")
    private String uploadPath;

    public void showAllforUser(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Rod> rods = productRepo.findAllProductforUser();
        if (filter != null && !filter.isEmpty()) {
            rods = productRepo.findByName(filter);
        } else {
            rods = productRepo.findAllProductforUser();
        }
        model.addAttribute("rods", rods);
        model.addAttribute("filter", filter);
    }

    public String showAllForAdmin(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Rod> rods = productRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            rods = productRepo.findByName(filter);
        } else {
            rods = productRepo.findAll();
        }
        model.addAttribute("rods", rods);
        model.addAttribute("filter", filter);
        return "/productsAdmin/rods";
    }


    public String updateProduct(@RequestParam String id,
                                @RequestParam String name,
                                @RequestParam String manufacturer,
                                @RequestParam String length,
                                @RequestParam String testMax,
                                @RequestParam String testMin,
                                @RequestParam String price,
                                @RequestParam String currentlyamount)
//                             @RequestParam("file") MultipartFile file) throws IOException
    {
        Rod product = new Rod();
        product.setId(Long.valueOf(id));
        product.setManufacturer(manufacturer);
        product.setName(name);
        product.setLength(Double.valueOf(length.replace(" ", "").replace(",", ".")));
        product.setTestMax(Double.valueOf(testMax.replace(" ", "").replace(",", ".")));
        product.setTestMin(Double.valueOf(testMin.replace(" ", "").replace(",", ".")));
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
        return "redirect:/rods";
    }

    public String deleteProductById(@PathVariable long id) {
        productRepo.deleteById(id);
        return "redirect:/rods";
    }

    public String editFormForProduct(@PathVariable Rod rod, Model model) {
        model.addAttribute("rod", rod);
        return "/productsAdmin/rodEdit";
    }

    public String formForAddProduct(@PathVariable Rod rod, Model model) {
        model.addAttribute("rod", rod);
        return "/productsUser/addRodToOrder";
    }

    public String addNewProduct(@RequestParam String name,
                                @RequestParam String manufacturer,
                                @RequestParam String length,
                                @RequestParam String testMax,
                                @RequestParam String testMin,
                                @RequestParam String price,
                                @RequestParam String currentlyamount)
//                             @RequestParam("file") MultipartFile file) throws IOException
    {
        Rod product = new Rod();
        product.setManufacturer(manufacturer);
        product.setName(name);
        product.setLength(Double.valueOf(length.replace(" ", "").replace(",", ".")));
        product.setTestMax(Double.valueOf(testMax.replace(" ", "").replace(",", ".")));
        product.setTestMin(Double.valueOf(testMin.replace(" ", "").replace(",", ".")));
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

        return "redirect:/rods";
    }

}
