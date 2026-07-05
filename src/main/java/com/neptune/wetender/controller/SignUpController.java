package com.neptune.wetender.controller;

import com.neptune.wetender.dto.request.SignUpRequest;
import com.neptune.wetender.service.SignUpService;
import com.neptune.wetender.dto.response.SignUpResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Resource
    private SignUpService signUpService;

    // Sign up
    @PostMapping
    public SignUpResponse signUp(@RequestBody SignUpRequest dto){
        return signUpService.signUpRecord(dto);
    }

}
