package com.example.testbvk.Service;

import com.example.testbvk.DTO.reqbody.LoginUserReqBody;
import com.example.testbvk.DTO.reqbody.MemberReqBody;
import com.example.testbvk.DTO.reqbody.RegisterUserReqBody;

public interface MemberInterface {
    Object save(MemberReqBody r, String path);
}

