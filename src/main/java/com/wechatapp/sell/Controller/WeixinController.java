package com.wechatapp.sell.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wexin")
@Slf4j // log
public class WeixinController {

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("GO TO auth METHOD...");
        // Before get code, we let the user open a url as document mentions.
        log.info("code = {}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxafafbd714ab6aed6&secret=c0e2309a7c143b9b2d96035e4cffd7ae&code="
                + code +"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        // send a get request to the url, return the response as a String
        String response = restTemplate.getForObject(url, String.class);
        log.error("Response = {}", response); // the response is a json, it contains openid which is important for the payment.
    }
}
