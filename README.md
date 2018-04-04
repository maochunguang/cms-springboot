# wxcms系统 springboot版本
## 特性
1. 多数据源拆分
2. 多环境配置，dev，test，prod三个环境
3. redis集群配置
4. 日志分类
5. 外网映射（方便调试）
6. 微信公众号支持
7. 微信公众号运营基本功能（菜单，打标签）

## 环境
jdk1.8
tomcat8.0
mysql5.7
maven构建
jenkins发布


## weixin-java-tools文档地址
微信使用sdk开发，[文档](https://gitee.com/binary/weixin-java-tools/wikis/pages?title=MP_demo%E4%BB%A3%E7%A0%81)

## entity定义

wxuser表结构
userid，酷我uid
openid，公众号openid
unionid，公众号unionid
tag，用户标签
state，关注状态，1，关注，0，未关注，2，取消
ctime，创建时间
utime，更新时间


