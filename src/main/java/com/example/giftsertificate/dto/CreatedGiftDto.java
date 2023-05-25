package com.example.giftsertificate.dto;

import com.example.giftsertificate.entity.TagEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedGiftDto {
    @Pattern(regexp = "^[A-Za-z]+$",
            message = "let there be only letters"
    )
    private String name;
    private String description;
    @Digits(fraction = 1,integer = 9999,message = "limit 9999 you have exceeded this number or small a number than 1")
    private Double price;
    @Digits(fraction = 1,integer = 999,message = "limit 999 you have exceeded this number or small a number  than 1")
    private Integer duration;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<TagEntity> tags;
}
