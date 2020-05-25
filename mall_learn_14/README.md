
基于 mall_learn_13 项目进行扩展。参见：[mall_learn_13](https://github.com/Deecyn/mall_learn/tree/master/mall_learn_13)

## 一、修改依赖注入的方式

修改项目中的依赖注入方式为「构造器注入」，具体原因请参考：[Spring 中不同依赖注入方式的对比与剖析](https://deecyn.com/spring-different-dependency-injection-methods.html) 。

其中，在配置类如 JwtAuthenticationTokenFilter、SpringSecurityConfig 这种并没有采用构造器注入的方式，因为它们之间存在着循环依赖的关系，需要依赖 Spring 自身的机制来解决循环依赖的问题。