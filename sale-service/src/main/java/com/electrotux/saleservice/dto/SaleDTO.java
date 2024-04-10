package com.electrotux.saleservice.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private Integer id;
    @Temporal(TemporalType.DATE)
    private LocalDate date_sale;

    private Integer cart_id;
}
