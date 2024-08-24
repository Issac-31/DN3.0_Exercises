package com.example.BookstoreAPI.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDTO {

    private int id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @Min(value = 0, message = "Price should be positive")
    private double price;

    @NotBlank(message = "ISBN is mandatory")
    @Size(min = 10, max = 13, message = "ISBN should be between 10 and 13 characters")
    private String isbn;
}
