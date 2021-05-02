package com.example.fishingstore.service.product;


import com.example.fishingstore.domain.products.Reel;
import com.example.fishingstore.repos.product.ReelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ServiceReel {
    @Autowired
    private ReelRepo productRepo;
    @Value("${upload.path}")
    private String uploadPath;

    public void showAllforUser (@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Reel> reels = productRepo.findAllProductforUser();
        if (filter != null && !filter.isEmpty()) {
            reels = productRepo.findByName(filter);
        } else {
            reels = productRepo.findAllProductforUser();
        }
        model.addAttribute("reels", reels);
        model.addAttribute("filter", filter);
    }

    public String showAllForAdmin(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Reel> reels = productRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            reels = productRepo.findByName(filter);
        } else {
            reels = productRepo.findAll();
        }
        model.addAttribute("reels", reels);
        model.addAttribute("filter", filter);
        return "/productsAdmin/reels";
    }

    public String updateProduct(@RequestParam String id,
                                @RequestParam String name,
                                @RequestParam String manufacturer,
                                @RequestParam String amount_balls,
                                @RequestParam String price,
                                @RequestParam String currentlyamount)
//                             @RequestParam("file") MultipartFile file) throws IOException
    {
        Reel product = new Reel();
        product.setId(Long.valueOf(id));
        product.setManufacturer(manufacturer);
        product.setName(name);
        product.setAmount_balls(Integer.valueOf(amount_balls));
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
        return "redirect:/reels";
    }

    public String deleteProductById(@PathVariable long id) {
        productRepo.deleteById(id);
        return "redirect:/reels";
    }

    public String editFormForProduct(@PathVariable Reel reel, Model model) {
        model.addAttribute("reel", reel);
        return "/productsAdmin/reelEdit";
    }

    public String formForAddProduct(@PathVariable Reel reel, Model model) {
        model.addAttribute("reel", reel);
        return "/productsUser/addReelToOrder";
    }

    public String addNewProduct(@RequestParam String name,
                                @RequestParam String manufacturer,
                                @RequestParam String amount_balls,
                                @RequestParam String price,
                                @RequestParam String currentlyamount)
//                             @RequestParam("file") MultipartFile file) throws IOException
    {
        Reel product = new Reel();
        product.setManufacturer(manufacturer);
        product.setName(name);
        product.setAmount_balls(Integer.valueOf(amount_balls));
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

        return "redirect:/reels";
    }

}
