package com.neptune.wetender;

import com.neptune.wetender.entity.UserDocument;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.neptune.wetender.repository.UserRepository;

import java.util.Optional;

@SpringBootTest
class WeTenderApplicationTests {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testInsert(){
        UserDocument user = new UserDocument();
        user.setUserName("testUser");
        user.setEmail("test@gmail.com");
        user.setPwdHash("pwdHash");

        UserDocument saved = userRepository.save(user);
        System.out.println("Successfully insert!" + saved.get_id());

        Optional<UserDocument> byId = userRepository.findById(saved.get_id());
        System.out.println("Find id: " + byId.isPresent());

        Optional<UserDocument> byEmail = userRepository.findByEmail(saved.getEmail());
        System.out.println("Find email:" + byEmail.isPresent());

        userRepository.deleteById(saved.get_id());
    }
}
