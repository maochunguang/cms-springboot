package com.cms.controller.wechat;

import com.cms.service.wechat.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maocg
 * @Date 2018/4/2
 * @Description TODO
 */
@RestController
@RequestMapping("/wx")
public class WxUserController extends WxController{
    @Autowired
    private WxUserService wxUserService;

    @GetMapping("/userInfo")
    public String queryUserInfo(@RequestParam String openId) {
        System.out.println("---------");
        try {
            wxUserService.queryUserInfo(openId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }


}
