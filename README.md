# bili_json_craw
调用bilibili手机端接口，爬取收藏夹，排行榜，历史记录等等数据

流程：

使用httpclient调用bilibili接口，获得一串json数据，用jackson处理并封装成javabean，然后用mybatis框架存入数据库

需要注意的是，这里的bilibili接口可以自己抓包，也可以使用官方提供的接口
详情看这里：https://github.com/fython/BilibiliAPIDocs
以及这里：http://docs.bilibili.cn/wiki（需科学）


这里提供的是调用httclient发送请求，以及处理接受到的json，最后存入数据库这样的功能
