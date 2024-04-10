package com.electrotux.shoppingservice.repository;

import com.electrotux.shoppingservice.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {
}
