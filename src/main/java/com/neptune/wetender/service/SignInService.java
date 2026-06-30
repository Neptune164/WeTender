package com.neptune.wetender.service;

import com.neptune.wetender.dto.SignInDto;
import com.neptune.wetender.entity.UserDocument;
import com.neptune.wetender.exception.EmailOrPwdInvalidException;
import com.neptune.wetender.repository.UserRepository;
import com.neptune.wetender.vo.SignInResponse;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SignInService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder encoder;

    public SignInResponse signInRecord(SignInDto dto){
        Optional<UserDocument> user = userRepository.findByEmail(dto.getEmail());
        SignInResponse response = new SignInResponse();
        if(user.isPresent()){
            UserDocument doc = user.get();
            if(encoder.matches(dto.getPwd(), doc.getPwdHash())){
                response.setId(doc.get_id());
                response.setUserName(doc.getUserName());
                response.setEmail(doc.getEmail());
                response.setSignInTime(LocalDateTime.now());
                response.setMessage("Sign in successfully!");
            }else{
                throw new EmailOrPwdInvalidException("Email or Password is invalid.");
            }
        }else{
            throw new EmailOrPwdInvalidException("Email or Password is invalid.");
        }
        return response;
    }
}
