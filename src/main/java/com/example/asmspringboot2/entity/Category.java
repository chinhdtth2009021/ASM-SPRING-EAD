package com.example.asmspringboot2.entity;

import com.example.asmspringboot2.entity.base.BaseEntity;
import com.example.asmspringboot2.entity.entityEnum.CategoryStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
@Inheritance
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private long parentId;
    private String description;
    private CategoryStatus status;
    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<Product> products;
}
