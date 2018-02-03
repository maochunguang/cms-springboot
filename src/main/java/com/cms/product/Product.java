package com.cms.product;

/**
 * @author mao
 * 2017/9/29
 * 业务线/产品线也行，存到数据库，启动应用时加载
 */
public class Product {
    private String id;
    private String name;
    private String desc;
    /**
     * md5加密使用（业务线通知加密）
     */
    private String md5Key;

    public String getMd5Key() {
        return md5Key;
    }

    public void setMd5Key(String md5Key) {
        this.md5Key = md5Key;
    }

    /**
     * 支付成功通知业务线的接口地址
     */
    private String notifyUrl;
    /**
     * 支付成功跳转地址
     */
    private String successUrl;
    /**
     * 支付失败跳转地址
     */
    private String failUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }
}
