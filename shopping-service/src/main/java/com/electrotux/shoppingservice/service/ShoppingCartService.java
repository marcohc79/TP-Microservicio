package com.electrotux.shoppingservice.service;

import com.electrotux.shoppingservice.dto.ProductDTO;
import com.electrotux.shoppingservice.model.ShoppingCart;
import com.electrotux.shoppingservice.repository.IProductAPI;
import com.electrotux.shoppingservice.repository.IShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartService implements IShoppingCartService {
    @Autowired
    private IShoppingCartRepository shoppingCartRepository;

    @Autowired
    private IProductAPI productAPI;

    @Override
    public void saveShoppingCart(Integer product_id) {
        ProductDTO productDTO = productAPI.getProductById(product_id);
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Integer> listIds = new ArrayList<Integer>();
        listIds.add(productDTO.getId());

        shoppingCart.setTotal_price(shoppingCart.getTotal_price() + productDTO.getPrice());
        shoppingCart.setProducts_id(listIds);

        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> getShoppingCarts() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public void deleteShoppingCart(Integer shoppinCardId) {
        shoppingCartRepository.deleteById(shoppinCardId);
    }

    @Override
    public ShoppingCart getShoppingCartById(Integer shoppinCardId) {
        return shoppingCartRepository.findById(shoppinCardId).orElse(null);
    }

    @Override
    public Boolean addProductToCart(Integer shoppingCardId, Integer product_id) {
        ShoppingCart shoppingCart = this.getShoppingCartById(shoppingCardId);
        ProductDTO productDTO = productAPI.getProductById(product_id);

        if (shoppingCart == null || productDTO == null)
            return false;

        List<Integer> listIds = shoppingCart.getProducts_id();
        listIds.add(productDTO.getId());

        shoppingCart.setTotal_price(shoppingCart.getTotal_price() + productDTO.getPrice());

        shoppingCartRepository.save(shoppingCart);
        return true;
    }

    @Override
    public Boolean removeProductFromCart(Integer shoppingCardId, Integer product_id) {
        ShoppingCart shoppingCart = this.getShoppingCartById(shoppingCardId);
        ProductDTO productDTO = productAPI.getProductById(product_id);

        if (shoppingCart == null || productDTO == null)
            return false;

        List<Integer> listIds = shoppingCart.getProducts_id();
        listIds.remove(productDTO.getId());

        shoppingCart.setTotal_price(shoppingCart.getTotal_price() - productDTO.getPrice());

        shoppingCartRepository.save(shoppingCart);
        return true;
    }

    @Override
    public Integer getCartTotalPrice(Integer shoppingCardId) {
        ShoppingCart shoppingCart = this.getShoppingCartById(shoppingCardId);
        return shoppingCart.getTotal_price();
    }


}
