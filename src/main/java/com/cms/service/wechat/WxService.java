package com.cms.service.wechat;

import com.cms.autoconfig.RedisConfig;
import com.cms.autoconfig.WechatMpConfig;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpInRedisConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author maocg
 * Date 2018/4/2
 * Description TODO
 */
@Service
public class WxService extends WxMpServiceImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WechatMpConfig wechatMpConfig;

    @Autowired
    private RedisConfig redisConfig;

    private WxMpMessageRouter wxMpMessageRouter;

    @PostConstruct
    public void init() {
        WxMpInRedisConfigStorage inRedisConfigStorage = new WxMpInRedisConfigStorage(redisConfig.getRedisPool());
        inRedisConfigStorage.setAppId(wechatMpConfig.getAppId());
        inRedisConfigStorage.setSecret(wechatMpConfig.getAppSecret());
        inRedisConfigStorage.setToken(wechatMpConfig.getToken());
        inRedisConfigStorage.setAesKey(wechatMpConfig.getAesKey());
        setWxMpConfigStorage(inRedisConfigStorage);
        wxMpMessageRouter = new WxMpMessageRouter(this);
        wxMpMessageRouter.rule().handler(new WxMpMessageHandler() {
            @Override
            public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
                logger.info("\n接收到 {} 公众号请求消息，内容：{}", wxMpService.getWxMpConfigStorage().getAppId(), wxMpXmlMessage);
                return null;
            }
        }).next();
    }
}
