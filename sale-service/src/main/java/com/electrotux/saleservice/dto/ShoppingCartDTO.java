package com.electrotux.saleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCartDTO {
    private Integer id;
    private Integer total_price=0;
    private List<Integer> products_id = new ArrayList<>();
}
