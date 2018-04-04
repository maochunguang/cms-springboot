package com.cms.controller.wechat;

import com.cms.service.wechat.WxAuthService;
import com.cms.service.wechat.WxService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageMatcher;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * @author maocg
 * @Date 2018/4/2
 * @Description 微信验证相关的请求
 */
@RestController
@RequestMapping("/wx")
public class WxAuthController extends WxController{
    @Autowired
    private WxAuthService wxAuthService;

    @GetMapping("/event")
    public String checkSignature(@RequestParam String timestamp, @RequestParam String echostr,
                                 @RequestParam String signature, @RequestParam String nonce) {
        System.out.println("aaaaaaaa");
//        signature	微信加密签名，
//        timestamp	时间戳
//        nonce	随机数
//        echostr	随机字符串
        Boolean isChecked = false;

        try {
            isChecked = wxAuthService.checkSignature(nonce, timestamp, signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isChecked) {
            return echostr;
        }
        return "FAIL";
    }

    @PostMapping("/event")
    public String handleEvent(HttpServletRequest request){
        try {
            WxMpXmlMessage  xmlMessage= WxMpXmlMessage.fromXml(request.getInputStream());
            WxMpMessageRouter router = new WxMpMessageRouter(this.wxAuthService);
            router.rule()
                    .msgType(WxConsts.XmlMsgType.TEXT).event(WxConsts.EventType.CLICK).eventKey("KEY_1").content("CONTENT_1")
                    .handler(new WxEchoMpMessageHandler(xmlMessage.toString(), "COMBINE_4"))
                    .end()
                    .rule()
                    .msgType(WxConsts.XmlMsgType.TEXT).event(WxConsts.EventType.CLICK).eventKey("KEY_1")
                    .handler(new WxEchoMpMessageHandler(xmlMessage.toString(), "COMBINE_3"))
                    .end()
                    .rule()
                    .msgType(WxConsts.XmlMsgType.TEXT).event(WxConsts.EventType.CLICK)
                    .handler(new WxEchoMpMessageHandler(xmlMessage.toString(), "COMBINE_2"))
                    .end()
                    .rule()
                    .msgType(WxConsts.XmlMsgType.TEXT)
                    .handler(new WxEchoMpMessageHandler(xmlMessage.toString(), WxConsts.XmlMsgType.TEXT)).end()
                    .rule()
                    .event(WxConsts.EventType.CLICK)
                    .handler(new WxEchoMpMessageHandler(xmlMessage.toString(), WxConsts.EventType.CLICK)).end();



        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static class WxEchoMpMessageHandler implements WxMpMessageHandler{
        private String msg ;
        private String echoStr;

        public WxEchoMpMessageHandler(String msg, String echoStr) {
            this.msg = msg;
            this.echoStr = echoStr;
        }
        @Override
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
            return null;
        }
    }

}


