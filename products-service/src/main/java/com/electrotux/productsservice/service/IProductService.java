package com.electrotux.productsservice.service;

import com.electrotux.productsservice.model.Product;

import java.util.List;

public interface IProductService {
    void saveProduct(Product product);
    List<Product> getProducts();
    Product findProductById(Integer product_id);
    Boolean deleteProductById(Integer product_id);
    Boolean editProduct(Integer product_id, String newName, String newBrand, Integer newPrice);
}
