package com.cms.service.wechat;

import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.stereotype.Service;

/**
 * @author maocg
 * Date 2018/4/2
 * Description TODO
 */
@Service
public class WxUserService extends WxService {

    public void queryUserInfo(String openId) throws WxErrorException {
        getUserService().userInfo(openId);
    }

}
