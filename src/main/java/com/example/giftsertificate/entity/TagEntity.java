package com.example.giftsertificate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "tags")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TagEntity extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String name;
}
