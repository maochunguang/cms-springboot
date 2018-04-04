package com.cms.autoconfig;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author maocg
 * Date 2018/4/2
 * Description TODO
 */
@Configuration
public class WechatMpConfig {
    /**
     * 设置微信三方平台的appid
     */
    @Value("${wechat.mp.appId}")
    private String appId;

    /**
     * 设置微信三方平台的app secret
     */
    @Value("${wechat.mp.appSecret}")
    private String appSecret;

    /**
     * 设置微信三方平台的token
     */
    @Value("${wechat.mp.token}")
    private String token;

    /**
     * 设置微信三方平台的EncodingAESKey
     */
    @Value("${wechat.mp.aesKey}")
    private String aesKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }
}
