package com.electrotux.shoppingservice.controller;

import com.electrotux.shoppingservice.model.ShoppingCart;
import com.electrotux.shoppingservice.repository.IShoppingCartRepository;
import com.electrotux.shoppingservice.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class ShoppingCartsController {
    @Autowired
    private IShoppingCartService shoppingCartService;

    @PostMapping("/save/{product_id}")
    public String saveShoppingCart(@PathVariable Integer product_id){
        shoppingCartService.saveShoppingCart(product_id);
        return "OK";
    }

    @GetMapping("/get")
    public List<ShoppingCart> getShoppingCarts (){
        return shoppingCartService.getShoppingCarts();
    }

    @DeleteMapping("/delete/{shoppigCartId}")
    public void deleteShoppingCartById(@PathVariable Integer shoppigCartId){
        shoppingCartService.deleteShoppingCart(shoppigCartId);
    }

    @GetMapping("/get/{shopping_id}")
    public ShoppingCart getShoppingCartById(@PathVariable Integer shopping_id){
        return shoppingCartService.getShoppingCartById(shopping_id);
    }

    @PutMapping("/products/add/{shoppig_id}/{product_id}")
    public String addProductToCart(@PathVariable Integer shoppig_id, @PathVariable Integer product_id){
        Boolean flag = shoppingCartService.addProductToCart(shoppig_id, product_id);
        if(flag)
            return "OK";
        return "ERROR";
    }

    @DeleteMapping("/products/remove/{shopping_id}/{product_id}")
    public String removeProductFromCart(@PathVariable Integer shopping_id, @PathVariable Integer product_id){
        Boolean flag = shoppingCartService.removeProductFromCart(shopping_id, product_id);
         if (flag)
             return "OK";
         return "ERROR";
    }

    @GetMapping("/get/totalprice/{shopping_id}")
    public Integer getTotalPrice(@PathVariable Integer shopping_id){
        return shoppingCartService.getCartTotalPrice(shopping_id);
    }
}
