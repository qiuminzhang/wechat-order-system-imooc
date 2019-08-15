package com.wechatapp.sell.Controller;


import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin")
@Slf4j // log
public class WeChatController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("GO TO auth METHOD...");
        log.info("code = {}", code);
    }

//    @GetMapping("/auth")
//    public void auth() {
//        log.info("GO TO auth METHOD...");
////        log.info("code =}", code); {
//    }
}
