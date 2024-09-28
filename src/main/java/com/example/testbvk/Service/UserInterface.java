package com.example.testbvk.Service;

import com.example.testbvk.DTO.reqbody.LoginUserReqBody;
import com.example.testbvk.DTO.reqbody.RegisterUserReqBody;

public interface UserInterface {
    Object userRegister(RegisterUserReqBody r);
    Object loginMember(LoginUserReqBody r);
    Object googleCallback(String email, String name);
}
