package com.neptune.wetender;

import com.neptune.wetender.properties.OllamaProperties;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeTenderApplicationTests {

    @Resource
    private OllamaProperties properties;

    @Test
    public void testEnv(){
        System.out.println(properties.getBaseUrl()+properties.getApiKey());
    }
}
