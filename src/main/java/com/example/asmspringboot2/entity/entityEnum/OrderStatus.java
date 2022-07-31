package com.example.asmspringboot2.entity.entityEnum;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum OrderStatus {
    PENDING(1),
    PROCESSING(2),
    SHIPPING(3),
    COMPLETED(4),
    CANCELLED(0),
    DELETED(-1),
    UNDEFINED(-2);
    private int value;

    public static OrderStatus of(int value) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.getValue() == value) {
                return orderStatus;
            }
        }
        return OrderStatus.UNDEFINED;
    }
}