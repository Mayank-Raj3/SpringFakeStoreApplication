package org.example.basicspringbootapplication.Controllers;

import org.example.basicspringbootapplication.DTO.UserDTO;
import org.example.basicspringbootapplication.Services.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService ;
    public UserController(IUserService _userService){
        this.userService = _userService ;
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return this.userService.getAllUser();
    }

}
