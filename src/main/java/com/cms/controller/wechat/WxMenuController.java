package com.cms.controller.wechat;

import com.cms.service.wechat.WxAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maocg
 * @Date 2018/4/2
 * @Description TODO
 */
@RestController
@RequestMapping("/wx")
public class WxMenuController extends WxController{
    @Autowired
    private WxAuthService wxAuthService;

    @GetMapping("/creatMenu")
    public String checkSignature() {
        System.out.println("---------");
        return "success";
    }
}
