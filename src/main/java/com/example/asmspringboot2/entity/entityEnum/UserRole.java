package com.example.asmspringboot2.entity.entityEnum;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserRole {
    ADMIN(1),
    USER(0),
    UNDEFINED(2);
    private int value;

    public static UserRole of(int value) {
        for (UserRole userRole : UserRole.values()) {
            if(userRole.getValue() == value) {
                return userRole;
            }
        }
        return UserRole.UNDEFINED;
    }
}