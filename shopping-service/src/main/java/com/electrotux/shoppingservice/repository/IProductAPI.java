package com.electrotux.shoppingservice.repository;

import com.electrotux.shoppingservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface IProductAPI {
    @GetMapping("/products/get/{product_id}")
    ProductDTO getProductById(@PathVariable("product_id") Integer product_id);
}
