package com.example.testbvk.Service.impl;

import com.example.testbvk.DTO.reqbody.LoginUserReqBody;
import com.example.testbvk.DTO.reqbody.RegisterUserReqBody;
import com.example.testbvk.Entity.UserEntity;
import com.example.testbvk.Repository.UserRepository;
import com.example.testbvk.Service.UserInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService implements UserInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public Object googleCallback(String email, String name){
        UserEntity user = userRepository.findByEmail(email);
        if(user == null){
            user = new UserEntity();
            user.setEmail(email);
            user.setUname(name);
            userRepository.save(user);
            return user;
        }

        return "Login success " + user.getEmail();
    }

    @Override
    public Object userRegister(RegisterUserReqBody r){

        try{
            Boolean isEmailExist = userRepository.isEmailExist(r.getEmail());
            if(isEmailExist){
                return "Email sudah digunakan";
            }
            UserEntity user = new UserEntity();
            user.setUname(r.getUname());
            user.setEmail(r.getEmail());
            user.setPassword(r.getPassword());

            user = userRepository.save(user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return "error : " +  e.getMessage();
        }
    }

    @Override
    public Object loginMember(LoginUserReqBody r){
        try{
            UserEntity member = userRepository.findByEmail(r.getEmail());
            if(member == null){
                return "User Tidak ditemukan";
            }

            if(member.getEmail().equals(r.getEmail()) && member.getPassword().equals(r.getPassword())) {
                return "Login Sukses" + r.getEmail();
            }else if(member.getEmail().equals(r.getEmail()) && !member.getPassword().equals(r.getPassword())){
                return "Password Salah";
            }else{
                return "Email Tidak Ditemukan";
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
