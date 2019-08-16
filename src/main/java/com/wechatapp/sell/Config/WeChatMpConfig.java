package com.wechatapp.sell.Config;


import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
/**
 * Configure a WxMpService, especially set the appId and appSecret for this service.
 * */
@Component
public class WeChatMpConfig {

    @Autowired
    private WeChatAccountConfig weChatAccountConfig;

    // TODO: what is bean? how does it work?
    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setSecret(weChatAccountConfig.getMpAppSecret());
        wxMpConfigStorage.setAppId(weChatAccountConfig.getMpAppId());
        return wxMpConfigStorage;    // WxMpDefaultConfigImpl is an implementation of WxMpConfigStorage
    }
}
