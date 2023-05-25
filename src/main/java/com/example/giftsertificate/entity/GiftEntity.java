package com.example.giftsertificate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity(name = "Gift")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GiftEntity extends BaseEntity {
    private String name;
    private String description;
    private Double price;
    private Integer duration;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<TagEntity>tags;
}
