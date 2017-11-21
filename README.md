一、项目简介
====

##1.项目模块介绍

##### (1) account 账户体系 

        账户体系，目前主要包括两块内容：
        a. 用户信息
        b. 设备信息

#####(2) authority 权限认证中心

        权限认证中心，主要包含的内容：
        a. 单点登录
        b. 权限统一认证
        c. 各系统配置管理
        d. 各系统接口管理

##### (3) common 公共模块

        公共模块，主要内容应该包括：
        a. 统一的常量定义
        b. 统一且不变的规则

#####(4) community 安心社区

        安心社区，主要包含的内容：
        a. 活动
        b. 会议
        c. 人物
        d. 百科
        e. 话题

##### (5) exam 考试系统

        考试系统，主要包含的内容：
        a. 试卷的管理
        b. 试卷的生成及其规则
        c. 题库的管理

#####(6) heart 安心网控制中心

        安心网控制中心的主要功能是，整合安心网首页

#####(7) institute 安心学院

        安心学院，主要功能包括：
        a. 视频系统
        b. 安心训练营
        c. 安心大比武 

##### (8) message 消息中心

        消息中心，主要负责消息形成和推送
        a. 短信信息
        b. 邮件消息
        c. 系统消息
        d. 消息模板
        g. 各系统业务日志

#####(9) payment 支付中心

        支付中心，主要内容包括：
        a. 支付订单
        b. 支付流水
        c. 第三方支付        

#####(10) platform 运营支撑平台

        运营支撑平台，目前包含：
        a. Banner管理
        b. 联系我们

#####(11) shop 电商中心

        电商中心，主要内容包括：
        a. 商品信息中心
        b. 商品订单管理
        c. 解决方案
        d. 优惠券

##2.项目技术架构

        项目使用的技术，都来于开源项目，有相当多的资料可供查询。

#####(1) 应用框架 [Spring](https://spring.io)

   + [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html) 
   + [Spring IOC](https://projects.spring.io/spring-framework/) 
   + [Spring security](https://projects.spring.io/spring-security/ )
   + [CAS](https://www.apereo.org/projects/cas)

#####(2) RPC框架 [Dubbox](https://github.com/hutai123/dubbox)

#####(3) 缓存技术 [Redis](https://redis.io)

#####(4) 持久化框架 [Mybatis](http://www.mybatis.org/mybatis-3/zh/)

#####(5) 数据库 [MariaDB](https://mariadb.org/)

#####(6) 搜索引擎 [ElasticSearch](https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html)

##3.概念

* VO（View Object）：视图对象，用于展示层，它的作用是把某个指定页面（或组件）的所有数据封装起来。
* DTO（Data Transfer Object）：数据传输对象，这个概念来源于J2EE的设计模式，原来的目的是为了EJB的分布式应用提供粗粒度的数据实体，以减少分布式调用的次数，从而提高分布式调用的性能和降低网络负载，但在这里，我泛指用于展示层与服务层之间的数据传输对象。
* DO（Domain Object）：领域对象，就是从现实世界中抽象出来的有形或无形的业务实体。
* PO（Persistent Object）：持久化对象，它跟持久层（通常是关系型数据库）的数据结构形成一一对应的映射关系，如果持久层是关系型数据库，那么，数据表中的每个字段（或若干个）就对应PO的一个（或若干个）属性。

##4.错误代码分配

| 系统名称    | 英文名称      | 错误码范围                  |
| ------- | --------- | ---------------------- |
| 账户体系    | account   | 000001~ 010000         |
| 权限认证    | authority | 010001 ~ 020000        |
| 公共模块    | common    | 000000，900001 ~ 999999 |
| 安心社区    | community | 020001 ~ 030000        |
| 考试系统    | exam      | 030001 ~ 040000        |
| 安心网控制中心 | heart     | 040001~ 050000         |
| 安心学院    | institute | 050001 ~ 060000        |
| 消息中心    | message   | 060001 ~ 070000        |
| 支付中心    | payment   | 070001 ~ 080000        |
| 运营支撑平台  | platform  | 080001 ~ 090000        |
| 电商中心    | shop      | 090001 ~ 100000        |

##5.Dubbo端口分配

| 系统名称    | 英文名称      | 端口范围          |
| ------- | --------- | ------------- |
| 账户体系    | account   | 20001 ~ 20100 |
| 权限认证    | authority | 20101 ~ 20200 |
| 安心社区    | community | 20201 ~ 20300 |
| 考试系统    | exam      | 20301 ~ 20400 |
| 安心网控制中心 | heart     | 20401 ~ 20500 |
| 安心学院    | institute | 20501 ~ 20600 |
| 消息中心    | message   | 20601 ~ 20700 |
| 支付中心    | payment   | 20701 ~ 20800 |
| 运营支撑平台  | platform  | 20801 ~ 20900 |
| 电商中心    | shop      | 20901 ~ 21000 |

