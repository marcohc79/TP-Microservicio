package com.electrotux.saleservice.controller;

import com.electrotux.saleservice.dto.SaleDTO;
import com.electrotux.saleservice.model.Sale;
import com.electrotux.saleservice.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SalesController {
    @Autowired
    private ISaleService saleService;

    @GetMapping("/get")
    public List<Sale> getSales() {
        return saleService.getAllSales();
    }

    @PostMapping("/save")
    public String saveSale(@RequestBody SaleDTO saleDTO) {
        saleService.save(saleDTO.getCart_id(), saleDTO.getDate_sale());
        return "Saved";
    }

    @GetMapping("/get/totalprice/{sale_id}")
    public Integer getTotalPrice(@PathVariable Integer sale_id) {
        return saleService.getPriceTotalByCartId(sale_id);
    }

}
