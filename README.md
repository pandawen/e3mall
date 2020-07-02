# 分布式网上商城
自己学习的网上商城

开发环境： eclipse+maven+svn+linux+easyui
软件架构： mysql+mybatis+spring+springmvc+redis+solr

项目描述：项目属于分布式电商项目，采用soa架构，类似京东。实现了用户在商城浏览商品、下订单，以及参加各种活动。管理员可后台管理商品和用户等信息，项目具有高并发访问的能力。项目各子系统之间都是调用服务来实现系统之间的通信，子系统之间通过dubbo中间件来进行通讯，并使用ActiveMQ来进行消息缓存，zookeeper来进行地址查询管理。这样降低了系统之间的耦合度，提高了系统的扩展性。同时为了提高系统的性能使用redis集群做系统缓存，并使用redis实现session共享。搜索系统使用solr集群做搜索引擎，使用FastDFS作为图片服务器。各子系统根据将来的访问量添加服务器并使用Nginx进行负载均衡管理。

系统架构：

后台管理系统(e3-manager及e3-manager-web)：管理商品、订单、类目、商品规格属性、用户管理以及内容发布等功能。

首页系统(e3-portal-web)：用户可以在首页浏览商品、查看广告。

购物车系统(e3-cart及e3-cart-web)：用户可以在该系统中查询已添加到购物车的商品信息。

订单系统(e3-order及e3-order-web)：提供下单、查询订单、修改订单状态。

商品详情页系统(e3-item-web):提供用户浏览商品的详细信息。

搜索系统(e3-search及e3-seache-web)：提供商品的搜索功能。

单点登录系统(e3-sso及e3-sso-web)：为多个系统之间提供用户登录凭证以及查询登录用户的信息。