package com.example.giftsertificate.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreatedTagDto {
    @Pattern(regexp = "^[A-Za-z]+$",
            message = "let there be only letters"
    )
    private String name;
}
