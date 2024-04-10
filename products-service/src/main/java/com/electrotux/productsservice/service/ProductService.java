package com.electrotux.productsservice.service;

import com.electrotux.productsservice.model.Product;
import com.electrotux.productsservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Integer product_id) {
        return productRepository.findById(product_id).orElse(null);
    }

    @Override
    public Boolean deleteProductById(Integer product_id) {
        if(this.findProductById(product_id) == null)
            return false;
        productRepository.deleteById(product_id);
        return true;
    }

    @Override
    public Boolean editProduct(Integer product_id, String newName, String newBrand, Integer newPrice) {
        Product editProduct = this.findProductById(product_id);

        if (editProduct != null){
            editProduct.setName(newName != null ? newName : editProduct.getName());
            editProduct.setBrand(newBrand != null ? newBrand : editProduct.getBrand());
            editProduct.setPrice(newPrice != null ? newPrice : editProduct.getPrice());
            productRepository.save(editProduct);
            return true;
        }
        return false;
    }
}
