package com.tts.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;

import com.tts.ecommerce.models.Product;
import com.tts.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


   @Controller
   @ControllerAdvice // This makes the `@ModelAttribute`s of this controller available to all controllers, for the navbar.
   public class MainController {
       @Autowired
       ProductService productService;



       public void addNew() {
        List<Product> allProducts = productService.findAll();

        if (allProducts.isEmpty()) {

            List<Product> newProducts = new ArrayList<Product>();

            newProducts.add(new Product(4, (float) 1500.00, "Nike Zoom Kobe 6 Grinch", "Kobe 6", "Nike", "basketball",
                    "images/KobeGrinch.jpeg"));

            newProducts.add(new Product(3, (float) 1000.00, "Air Jordan 1 Retro Mocha", "Air Jordan 1", "Jordan", "basketball",
                    "images/AJ1Mocha.jpeg"));

            newProducts.add(new Product(12, (float) 800.00, "Nike SB Mens Dunk Low 'Ben & Jerry's'", "Nike SB Mens Dunk Low", "Nike", "skateboarding",
                    "images/NikeBenJerry.jpeg"));

            newProducts.add(new Product(7, (float) 700.00, "Adidas Yeezy Boost 700 Mauve", "Adidas Yeezy Boost 700", "Adidas", "running",
                    "images/YZY700.jpeg"));
            
            newProducts.add(new Product(7, (float) 700.00, "Adidas Pharrell X NMD Human Race 'Yellow'", "Adidas NMD", "Adidas", "running",
                    "images/AdidasHMR.jpeg"));

            for (Product product : newProducts) {
                productService.save(product);
            }
        } else {

            System.out.println("You don't need more items!");
        }
    }
    
 
       @GetMapping("/")
       public String main() {

           addNew(); 
           return "main";
       }
 
       @ModelAttribute("products")
       public List<Product> products() {
           return productService.findAll();
       }
 
       @ModelAttribute("categories")
       public List<String> categories() {
           return productService.findDistinctCategories();
       }
 
       @ModelAttribute("brands")
       public List<String> brands() {
           return productService.findDistinctBrands();
       }
 
       @GetMapping("/filter")
       public String filter(@RequestParam(required = false) String category,
                            @RequestParam(required = false) String brand,
                            Model model) {
           List<Product> filtered = productService.findByBrandAndOrCategory(brand, category);
           model.addAttribute("products", filtered); // Overrides the @ModelAttribute above.
           return "main";
       }
 
       @GetMapping("/about")
       public String about() {
           return "about";
       }

      
    }
   


