package com.cms.service.wechat;

import org.springframework.stereotype.Service;

/**
 * @author maocg
 * Date 2018/4/2
 * Description 微信认证相关的服务
 */
@Service
public class WxAuthService extends WxService {

    public boolean checkSignature(String nonce, String timestamp, String signature) {
        return super.checkSignature(timestamp, nonce, signature);
    }

}
