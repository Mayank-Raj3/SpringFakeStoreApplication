package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.UserDTO;
import org.example.basicspringbootapplication.gateways.IUserGateWay;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreUserService implements IUserService{
    private final IUserGateWay iUserGateWay;
    public FakeStoreUserService(IUserGateWay _iUserGateWay) {
        this.iUserGateWay = _iUserGateWay;
    }
    @Override
    public List<UserDTO> getAllUser(){
        return this.iUserGateWay.getAllusers();
    }

}
