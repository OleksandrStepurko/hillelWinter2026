package com.shop.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class OrderUpdateDto {
    private long id; // order identifier
    private List<Long> products;
}
