package com.electrotux.shoppingservice.service;

import com.electrotux.shoppingservice.model.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    void saveShoppingCart(Integer product_id);
    List<ShoppingCart> getShoppingCarts();
    void deleteShoppingCart(Integer shoppinCardId);
    ShoppingCart getShoppingCartById(Integer shoppinCardId);
    Boolean addProductToCart(Integer shoppingCardId, Integer product_id);
    Boolean removeProductFromCart(Integer shoppingCardId, Integer product_id);
    Integer getCartTotalPrice(Integer shoppingCardId);
}
