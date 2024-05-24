package com.example.OnlineBookStore.controller.book;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationForm {

    @NotBlank
    @Size(max = 256)
    private String title;

    @NotBlank
    @Size(max = 256)
    private String author;

    @Max(100000)
    private int price;

    @Max(10000)
    private int stock;

}
