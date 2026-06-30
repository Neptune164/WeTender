package com.neptune.wetender.service;

import com.neptune.wetender.dto.SignUpDto;
import com.neptune.wetender.entity.UserDocument;
import com.neptune.wetender.exception.EmailAlreadyExistsException;
import com.neptune.wetender.repository.UserRepository;
import com.neptune.wetender.vo.SignUpResponse;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SignUpService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder encoder;

    public SignUpResponse signUpRecord(SignUpDto dto){
        // Request DTO and Document
        UserDocument user = new UserDocument();
        user.setUserName(dto.getUserName());
        if(!userRepository.existsByEmail(dto.getEmail())){
            user.setEmail(dto.getEmail());
        }else{
            throw new EmailAlreadyExistsException("Email already exists.");
        }
        String pwdHash = encoder.encode(dto.getPwd());
        user.setPwdHash(pwdHash);
        user.setCreatedAt(LocalDateTime.now());
        UserDocument saved = userRepository.save(user);

        // Response DTO
        SignUpResponse response = new SignUpResponse();
        response.setId(saved.get_id());
        response.setUserName(saved.getUserName());
        response.setEmail(saved.getEmail());
        response.setMessage("Signed up successfully!");
        response.setCreatedAt(saved.getCreatedAt());
        return response;
    }
}