package com.example.testbvk.Service.impl;

import com.example.testbvk.DTO.reqbody.MemberReqBody;
import com.example.testbvk.Entity.MemberEntity;
import com.example.testbvk.Repository.MemberRepository;
import com.example.testbvk.Service.MemberInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberService implements MemberInterface {
    @Autowired
    MemberRepository memberRepository;

    @Override
    public Object save(MemberReqBody r, String path){
        try{
            MemberEntity m = new MemberEntity();
            m.setEmail(r.getEmail());
            m.setName(r.getName());
            m.setPicture(path);
            m.setJoinDate(r.getJoinDate());
            m = memberRepository.save(m);
            return m;
        }catch (Exception e){
            e.printStackTrace();
            return "error : " +  e.getMessage();
        }
    }
}
