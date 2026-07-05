package com.neptune.wetender.controller;

import com.neptune.wetender.dto.request.SignInRequest;
import com.neptune.wetender.service.SignInService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signin")
public class SignInController {

    @Resource
    private SignInService signInService;

    @PostMapping
    public com.neptune.wetender.dto.response.SignInResponse signIn(@RequestBody SignInRequest dto){
        return signInService.signInRecord(dto);
    }
}
