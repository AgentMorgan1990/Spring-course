package ru.gb.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.gb.spring.data.Product;
import ru.gb.spring.repositories.ProductsRepository;

@Controller
public class MainController {

ProductsRepository repository;
@Autowired
    public MainController(ProductsRepository repository) {
        this.repository = repository;
    }

    //http://localhost:8189/app/add?a=12&b=45
    @GetMapping("/add")
    @ResponseBody
    public int add(@RequestParam int a, @RequestParam int b) {
        System.out.println(a + " " + b);
        return a + b;
    }


    //http://localhost:8189/app/product/45/info
    @GetMapping("/product/{id}/info")
    @ResponseBody
    public int findProduct(@PathVariable int id) {
        return id;
    }

    @GetMapping("/products")
    public String showProductPage(Model model){
        model.addAttribute("productsList",repository.getAllProduts());
        return "products_page";
    }

    @GetMapping("/product/{id}")
    public String findProduct(Model model,@PathVariable Long id) {
    Product product = repository.findById(id);
        model.addAttribute("productInfo",product);
        return "product_page";
    }
}