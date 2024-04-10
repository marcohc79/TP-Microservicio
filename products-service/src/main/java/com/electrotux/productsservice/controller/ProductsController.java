package com.electrotux.productsservice.controller;

import com.electrotux.productsservice.model.Product;
import com.electrotux.productsservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private IProductService productService;

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return "Saved product";
    }

    @GetMapping("/get")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/get/{product_id}")
    public Product getProductById(@PathVariable Integer product_id){
        return productService.findProductById(product_id);
    }

    @PutMapping("/edit/{product_id}")
    public String editProduct(@PathVariable Integer product_id,
                              @RequestParam(required = false, name = "name") String newName,
                              @RequestParam(required = false, name = "brand") String newBrand,
                              @RequestParam(required = false, name = "price") Integer newPrice){

        Boolean flag = productService.editProduct(product_id, newName, newBrand, newPrice);
        if (flag)
            return "Was correctly edit";
        return "Wasn't correctly edit";
    }

    @DeleteMapping("/delete/{product_id}")
    public String deleteProductById(@PathVariable Integer product_id){
        if (productService.deleteProductById(product_id))
            return "Delete OK";
        return "An error occurred";
    }
}
