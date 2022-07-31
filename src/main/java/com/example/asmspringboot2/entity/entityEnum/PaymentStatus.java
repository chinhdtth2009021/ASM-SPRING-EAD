package com.example.asmspringboot2.entity.entityEnum;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum PaymentStatus {
    PAID(1),
    UNPAID(0),
    DEBT(2),
    UNDEFINED(-1);
    private int value;

    public static PaymentStatus of(int value) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if(paymentStatus.getValue() == value) {
                return paymentStatus;
            }
        }
        return PaymentStatus.UNDEFINED;
    }
}
