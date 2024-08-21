package com.example.BookstoreAPI.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
}
