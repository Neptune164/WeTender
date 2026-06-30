package com.neptune.wetender.controller;

import com.neptune.wetender.dto.SignUpDto;
import com.neptune.wetender.service.SignUpService;
import com.neptune.wetender.vo.SignUpResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Resource
    private SignUpService signUpService;

    // Sign up
    @PostMapping
    public SignUpResponse signUp(@RequestBody SignUpDto dto){
        return signUpService.signUpRecord(dto);
    }

}
