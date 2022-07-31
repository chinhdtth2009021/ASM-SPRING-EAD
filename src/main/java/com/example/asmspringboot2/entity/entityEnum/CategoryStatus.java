package com.example.asmspringboot2.entity.entityEnum;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CategoryStatus {
    ACTIVE(1),
    DEACTIVE(0),
    DELETED(-1),
    UNDEFINED(2);
    private int value;

    public static CategoryStatus of(int value) {
        for (CategoryStatus categoryStatus : CategoryStatus.values()) {
            if(categoryStatus.getValue() == value) {
                return categoryStatus;
            }
        }
        return CategoryStatus.UNDEFINED;
    }
}
