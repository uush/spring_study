package com.example.taco_cloud;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor  // 기본 생성자 추가
public class Taco {

    @Nonnull   
    @Size(min = 5, message = "Name must be at least 5 characters long") 
    private String name;

    @Size(min = 5, message = "You must choose at least 1 ingredient")
    private List<String> ingredients;
}
