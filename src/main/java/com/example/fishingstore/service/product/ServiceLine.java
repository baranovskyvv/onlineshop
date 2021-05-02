package com.example.fishingstore.service.product;

import com.example.fishingstore.domain.products.Line;
import com.example.fishingstore.repos.product.LineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Service
public class ServiceLine {
@Autowired
    private LineRepo productRepo;
    @Value("${upload.path}")
    private String uploadPath;

    public void showAllOrFindByName(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Line> lines = productRepo.findAllLineforUser();
        if (filter != null && !filter.isEmpty()) {
            lines = productRepo.findByName(filter);
        } else {
            lines = productRepo.findAllLineforUser();
        }
        model.addAttribute("lines", lines);
        model.addAttribute("filter", filter);
    }

    public String showAllForAdmin(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Line> lines = productRepo.findAll();
        if (filter != null && !filter.isEmpty()) {
            lines = productRepo.findByName(filter);
        } else {
            lines = productRepo.findAll();
        }
        model.addAttribute("lines", lines);
        model.addAttribute("filter", filter);
        return "/productsAdmin/lines";
    }

    public String updateLine(@RequestParam String id,
                             @RequestParam String name,
                             @RequestParam String manufacturer,
                             @RequestParam String length,
                             @RequestParam String diameter,
                             @RequestParam String price,
                             @RequestParam String currentlyamount)
//                             @RequestParam("file") MultipartFile file) throws IOException
    {
        Line line = new Line();
        line.setId(Long.valueOf(id));
        line.setManufacturer(manufacturer);
        line.setName(name);
        line.setLength(Double.valueOf(length.replace(" ", "").replace(",", ".")));
        line.setDiameter(Double.valueOf(diameter.replace(" ", "").replace(",", ".")));
        line.setCurrentlyamount(Integer.valueOf(currentlyamount.replace(" ", "")));
        line.setPrice(Double.valueOf(price.replace(" ", "").replace(",", ".")));
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
        productRepo.save(line);
        return "redirect:/lines";
    }
    public String deleteLineById(@PathVariable long id) {
        productRepo.deleteById(id);
        return "redirect:/lines";
    }
    public String editFormForLine(@PathVariable Line line, Model model) {
        model.addAttribute("line", line);
        return "/productsAdmin/lineEdit";
    }
    public String formForAddLine(@PathVariable Line line, Model model) {
        model.addAttribute("line", line);
        return "/productsUser/addLineToOrder";
    }
    public String addNewLine(@RequestParam String name,
                             @RequestParam String manufacturer,
                             @RequestParam String length,
                             @RequestParam String diameter,
                             @RequestParam String price,
                             @RequestParam String currentlyamount)
//                             @RequestParam("file") MultipartFile file) throws IOException
    {
        Line line = new Line();
        line.setManufacturer(manufacturer);
        line.setName(name);
        line.setLength(Double.valueOf(length));
        line.setDiameter(Double.valueOf(diameter));
        line.setCurrentlyamount(Integer.valueOf(currentlyamount));
        line.setPrice(Double.valueOf(price));
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
        productRepo.save(line);

        return "redirect:/lines";
    }

}
