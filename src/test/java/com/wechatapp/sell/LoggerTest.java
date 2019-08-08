package com.wechatapp.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    // The class name in the getLogger must be the current class
    // If you don't want to type class name everytime, you can just use @Slf4j annotation
    private final Logger logger = LoggerFactory.getLogger((LoggerTest.class));
    @Test
    public void test1(){
        // The output in console only has Error and Info, because info and error
        // have higher lever than debug. You can check level by command+O(this is ou), type Level
        // and find level in org.slf4j.event.
        String name = "IMOOC";
        String psw = "123456";
        logger.debug("debug...");
        logger.info("name: " + name + " password: " + psw);

        logger.info("name: {}, password: {}", name, psw);
        logger.error("error...");
    }
}
