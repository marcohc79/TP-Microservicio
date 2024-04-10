package com.electrotux.saleservice.service;

import com.electrotux.saleservice.dto.ShoppingCartDTO;
import com.electrotux.saleservice.model.Sale;
import com.electrotux.saleservice.repository.ISaleRepository;
import com.electrotux.saleservice.repository.IShoppingAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISaleService{
    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private IShoppingAPI shoppingAPI;

    @Override
    public void save(Integer cart_id, LocalDate date) {
        ShoppingCartDTO shoppingCartDTO = shoppingAPI.getShoppingCartById(cart_id);
        if(shoppingCartDTO == null)
            return;
        Sale sale = new Sale();
        sale.setCart_id(cart_id);
        sale.setDate_sale(date);
        saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(Integer id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSaleById(Integer id) {
        saleRepository.deleteById(id);
    }

    @Override
    public void updateSale(Integer sale_id, Integer cartIdNew, LocalDate dateNew) {
        Sale sale = this.getSaleById(sale_id);
        if (sale == null)
            return;

        sale.setCart_id(cartIdNew != null ? cartIdNew : sale.getCart_id());
        sale.setDate_sale(dateNew != null ? dateNew : sale.getDate_sale());
        saleRepository.save(sale);
    }

    @Override
    public Integer getPriceTotalByCartId(Integer cartId) {
        ShoppingCartDTO cartDTO = shoppingAPI.getShoppingCartById(cartId);
        return cartDTO.getTotal_price();
    }
}
