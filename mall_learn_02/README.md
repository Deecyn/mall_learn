## 关于 mall_learn_02

使用了 SpringBoot，MyBatis（MyBatis-Generator、PageHelper 的使用）搭建了基本骨架，api 接口测试通过。

添加了 Swagger2 和 Swagger-ui 的使用。

整合Redis缓存功能，并以短信验证码的缓存为例验证。

修改 pom.xml 文件，忽略原版本的 swagger-annotations 和 swagger-models，重新添加 1.5.21 版本的；
用以解决 Illegal DefaultValue null for parameter type integer 和 NumberFormatException:
For input string: "" 异常。