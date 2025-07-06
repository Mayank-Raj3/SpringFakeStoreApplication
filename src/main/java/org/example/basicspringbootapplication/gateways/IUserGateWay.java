package org.example.basicspringbootapplication.gateways;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.DTO.UserDTO;

import java.io.IOException;
import java.util.List;

public interface IUserGateWay {
    public List<UserDTO> getAllusers() ;

}
