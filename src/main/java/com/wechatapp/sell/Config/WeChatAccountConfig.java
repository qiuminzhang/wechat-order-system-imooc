package com.wechatapp.sell.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatAccountConfig {
    private String mpAppId;
    private String mpAppSecret;

    private String mchId;
    private String mchKey;
    private String keyPath;

    /** wechat异步通知地址 */
    private String notifyUrl;
}
