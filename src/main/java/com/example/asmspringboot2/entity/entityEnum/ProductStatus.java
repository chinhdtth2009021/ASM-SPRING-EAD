package com.example.asmspringboot2.entity.entityEnum;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ProductStatus {
    ACTIVE(1),
    DEACTIVE(0),
    STOCKING(2),
    OUT_OF_STOCK(3),
    DELETED(-1),
    UNDEFINED(-2);
    private int value;

    public static ProductStatus of(int value) {
        for (ProductStatus productStatus : ProductStatus.values()) {
            if(productStatus.getValue() == value) {
                return productStatus;
            }
        }
        return ProductStatus.UNDEFINED;
    }
}
