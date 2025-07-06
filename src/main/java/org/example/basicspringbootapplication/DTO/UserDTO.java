package org.example.basicspringbootapplication.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;
}

