package com.electrotux.saleservice.service;

import com.electrotux.saleservice.model.Sale;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    void save(Integer cart_id, LocalDate date);
    List<Sale> getAllSales();
    Sale getSaleById(Integer id);
    void deleteSaleById(Integer id);
    void updateSale(Integer sale_id, Integer cartIdNew, LocalDate dateNew);
    Integer getPriceTotalByCartId(Integer cartId);
}
