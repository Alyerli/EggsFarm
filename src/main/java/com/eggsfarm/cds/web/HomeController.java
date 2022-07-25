package com.eggsfarm.cds.web;

import com.eggsfarm.cds.domain.Products;
import com.eggsfarm.cds.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User user) {
        var products = productService.listarProducts();
        log.info("Ejecutando el controlador desde MVC Spring");
        log.info("Usuario que inicio sesion: " + user);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/add")
    public String add(Products products) {
        return "update";
    }

    @PostMapping("/save")
    public String save(Products products) {
        productService.save(products);
        return "redirect:/";
    }

    @GetMapping("/update/{idProducts}")
    public String update(Products products, Model model) {
        products = productService.findProducts(products);
        model.addAttribute("products", products);
        return "update";
    }

    @GetMapping("/delete/{idProducts}")
    public String delete(Products products) {
        productService.delete(products);
        return "redirect:/";
    }
}
