package com.wechatapp.sell.Controller;

import com.wechatapp.sell.Config.WeChatMpConfig;
import com.wechatapp.sell.Enums.ResultEnum;
import com.wechatapp.sell.Exception.SellException;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

@Controller // Because @RestController returns json, if we want to redirect, we need to use @controller herr.
@RequestMapping("/wechat")
@Slf4j // log
public class WeChatController {

    @Autowired
    private WxMpService wxMpService;   // TODO: WxMpService is a dependency, and there is no class have the same name, wht autowire here as if it's a self-defined class?

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl){
        // 1. configuration
        // 2. call method
        String redirect_uri = "http://10.0.0.92:8080/sell/wechat/userinfo";
        // redirectUrl contains code and state which are params in the redirectUrl
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(redirect_uri, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code, result = {}", redirectUrl);

        return "redirect:" + redirectUrl;   // redirect to /userinfo which trigger the userInfo() method.
    }

    // 运行完suthorize方法后，重定向到redirectUrl，which is userInfo，触发了userInfo方法。这时就会拿到code， state，
    // 然后进一步请求access_token和openid
    @GetMapping("/userinfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            // use the code to get access_token and openid
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);  // It might have unhandled exception, so we use try catch to deal with it.
        } catch (WxErrorException e) {
            log.error("【微信网页授权】 {}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }

        String openId = wxMpOAuth2AccessToken.getOpenId();
        log.info("redirectUrl:" + returnUrl + "?openid=" + openId);

        return "redirectUrl:" + returnUrl + "?openid=" + openId;
        // Because @Controller enables redirection, the process wll end up with redirecting
        // to returnUrl + "?openid=" + openId.
        // TODO: why "redirectUrl" in the start of return? does it mean redirect? doesn't it bother?
    }
}
