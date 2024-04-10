package com.electrotux.saleservice.repository;

import com.electrotux.saleservice.dto.ShoppingCartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "shopping-service")
public interface IShoppingAPI {
    @GetMapping("/carts/get/{shopping_id}")
    ShoppingCartDTO getShoppingCartById(@PathVariable("shopping_id") Integer shoppingId);

}
