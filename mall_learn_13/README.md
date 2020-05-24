基于 mall_learn_02 项目进行扩展。参考：[mall_learn_02](https://github.com/Deecyn/mall_learn/tree/master/mall_learn_02) 。

此项目主要是增加了 **Spring Security 和 JWT 的整合**，文档目录如下：

* [一、关于 JWT (JSON Web Token)：](#一关于-jwt-json-web-token)
    * [1. JWT 的格式](#1-jwt-的格式)
    * [2. JWT 的配置](#2-jwt-的配置)
* [二、关于 Spring Security](#二关于-spring-security)
    * [@EnableWebSecurity 注解](#enablewebsecurity-注解)
    * [WebSecurityConfigurerAdapter 抽象类](#websecurityconfigureradapter-抽象类)
    * [关于 UserDetails](#关于-userdetails)
    * [关于 Authentication 和 SecurityContextHolder](#关于-Authentication-和-SecurityContextHolder)
    * [密码的加密与解密验证](#密码的加密与解密验证)
* [三、Spring Security 与 JWT 的整合](#三spring-security-与-jwt-的整合)

Spring Security 是一个基于 Spring 的、功能强大且高度可定制的身份验证和访问控制框架。 JWT (JSON Web Token) 是为了在网络环境中传递声明而设计的一种基于 JSON 的开放式标准（RFC 7519），该 token 被设计为紧凑且安全的，一般被用来在服务端和客户端之间传递、认证身份信息。

在 Spring Security 和 JWT 的整合中，JWT 充当着一个过滤器（FIlter）的角色，用于拦截客户端的请求，进行身份信息的认证。

## 一、关于 JWT (JSON Web Token)：

### 1. JWT 的格式

JWT 由 header.payload.signature 三部分组成：

```
// Header：
{
  // 签名的生成算法
  "alg": "HS256", 
  // 这个 token 的类型，JWT 中统一写为 JWT。 
  "typ": "JWT"  
}

// Payload，负载，用于存放用户名、token 的生成时间和过期时间等信息。
//   Payload 的每一项又叫一个 Claim，所以 payload 又被称为 Claims 。如下：
{
  // 主题，用户名（Subject）
  "sub": "svlada@gmail.com", 
  // 权限范围 
  "scopes": [  
    "ROLE_ADMIN",
    "ROLE_PREMIUM_MEMBER"
  ],
  // 签发人（issuer）
  "iss": "http://svlada.com", 
  // 签发时间（Issued At） 
  "iat": 1472033308, 
  // 过期时间（expiration time） 
  "exp": 147,  
  // 编号（JWT ID）
  "jti": "90afe78c-1d2e-4869-a77e-1d754b60e0ce" 
}

// Signature，签名，根据 Header 中的签名算法和服务端指定的一个密钥（secret），
//   对 Header 和 payload 中的内容进行 base64 编码后，再加密生成。
//   一旦 header 和 payload 被篡改，验证将失败。如下：
HMACSHA512(
  base64UrlEncode(header) + "." + 
  base64UrlEncode(payload),
  secret
)
```

将上面 header.payload.signature 三部分的内容 base64 编码可得到一个 JWT 的字符串，例如：

```js
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE1NTY3NzkxMjUzMDksImV4cCI6MTU1NzM4MzkyNX0.d-iki0193X0bBOETf2UN3r3PotNIEAV7mzIxxeI5IxFyzzkOZxS0PGfF_SK6wxCv2K8S0cZjMkv6b5bCqc0VBw
```

为了支持跨域，通常将这个 token 字符串通过 Http 的 Header 传送：（其中，Bearer 表示一种身份认证方案，其它的认证方案还有 Basic、Digest、Mutual 等，参考 [IANA 维护的一系列 HTTP 的认证方案](http://www.iana.org/assignments/http-authschemes/http-authschemes.xhtml) 。）

```html
Authorization: Bearer<token>
```

也可以放在 Post 请求的数据体重。

### 2. JWT 的配置

JWT token 的工具类，根据用户信息生成 token、从 token 中解析中相关信息、判断 token 是否有效等。代码文件如下：

[JwtTokenUtil.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/common/util/JwtTokenUtil.java)

JWT 过滤器的设置：

[JwtAuthenticationTokenFilter.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/component/JwtAuthenticationTokenFilter.java)



## 二、关于 Spring Security

关于 Spring Security 的配置的代码文件如下：

[SpringSecurityConfig.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/config/SpringSecurityConfig.java)

### @EnableWebSecurity 注解

该注解和 `@Configuration` 注解一起使用。注解 `WebSecurityConfigurer` 类型的类，或者注解继承自 `WebSecurityConfigurerAdapter`的类，这样就构成了 *Spring Security* 的配置类。

### WebSecurityConfigurerAdapter 抽象类

 它提供了一种便利的方式去创建 `WebSecurityConfigurer` 类的实例，只需要重写 `WebSecurityConfigurerAdapter` 的方法，即可配置拦截什么 URL、设置什么权限等安全控制。一般继承此类时需要覆写 `#configure(AuthenticationManagerBuilder auth)` 和 `#configure(HttpSecurity http)` 方法。

### 关于 UserDetails

在用户进行登录或其它操作时，系统会根据用户名，从存储设备中查找该用户的密码、权限、账户是否有效等信息，将其封装成一个临时的 UserDetails 对象，并用 UserDetails 对象中的数据对用户进行认证。也可以根据自己的业务需求对该类进行扩展或自定义，例如 [AdminUserDetails.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/dto/AdminUserDetails.java) 类。

对于从存储设备中查找该用户的信息用于封装 UserDetails 对象，则封装在 UserDetailsService 接口的实现中，该接口中只有一个 loadUserByUsername() 方法：

```java
// org.springframework.security.core.userdetails.UserDetailsService
public interface UserDetailsService {
    
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
```

可以通过覆写 loadUserByUsername() 方法来自定义用户信息的加载逻辑，例如 [SpringSecurityConfig.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/config/SpringSecurityConfig.java) 中的以下代码：

```java
/**
 * 用于配置 AuthenticationManagerBuilder 创建的 AuthenticationManager 对象；
 * AuthenticationManager 对象用于实现内存验证、LADP 验证、基于 JDBC 的验证等。
 */
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService())
      .passwordEncoder(passwordEncoder());
}

// 省略其它代码的展示···

/**
 * 自定义 UserDetailsService 中的 loadUserByUsername() 方法的逻辑
 */
@Bean
public UserDetailsService userDetailsService(){
    // 这里使用 Lambda 表达式实现
    return username -> {
      	UmsAdmin admin = umsAdminService.getAdminByUsername(username);
        if (admin != null) {
            List<UmsPermission> permissionList = 
                     umsAdminService.getPermissionList(admin.getId());
            return new AdminUserDetails(admin, permissionList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    };
}
```

### 关于 Authentication 和 SecurityContextHolder

在 [JwtAuthenticationTokenFilter.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/component/JwtAuthenticationTokenFilter.java) 过滤器以及登录等逻辑中，用到了 SecurityContextHolder 和 Authentication 来检验用户的身份。

其中，**Authentication** 是 Spring Security 的一个核心接口，在用户登录认证成功之后会为其生成一个信息更全面的 Authentication 对象，然后把它保存在 SecurityContextHolder 所持有的 SecurityContext 中，供后续的程序进行调用，如身份的认证、访问权限的鉴定等。

**SecurityContextHolder** 是用来保存 SecurityContext 的，它持有着当前用户的 SecurityContext 。而 SecurityContext 持有的是代表当前用户相关信息的 Authentication 对象的引用，这个 Authentication 对象不需要我们自己去创建，在与系统交互的过程中，Spring Security 会自动为我们创建。

### 密码的加密与解密验证

在 [SpringSecurityConfig.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/config/SpringSecurityConfig.java) 中有以下代码：

```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService())
        .passwordEncoder(passwordEncoder());
}

/** 设置对密码加密的编码器  */
@Bean
public PasswordEncoder passwordEncoder() { 
    return new BCryptPasswordEncoder();
}
```

> 编码器 BCryptPasswordEncoder 的相关知识：
>
> 用户表的密码通常使用 MD5 等不可逆算法加密后存储，为防止彩虹表破解更会先使用一个特定的字符串（如域名）加密，然后再使用一个随机的 salt（盐值）加密。
>
> 特定字符串是程序代码中固定的，salt 是每个密码单独随机，一般给用户表加一个字段单独存储，比较麻烦。BCrypt 算法将 salt 随机并混入最终加密后的密码，验证时也无需单独提供之前的 salt，从而无需单独处理 salt 问题。

在使用时，可以通过 BCryptPasswordEncoder 对象的 encode() 方法进行加密，使用 matches() 方法进行密码的匹配。

## 三、Spring Security 与 JWT 的整合

在 Spring Security 默认的过滤器链中，有很多的过滤器，如 CsrfFilter、UsernamePasswordAuthenticationFilter、SessionManagementFilter 等，具体参加 [官网](https://docs.spring.io/spring-security/site/docs/5.0.0.M1/reference/htmlsingle/#ns-custom-filters) 。

在前面说过，在 Spring Security 和 JWT 的整合中，JWT 充当着一个过滤器（FIlter）的角色，用于拦截客户端的请求，进行身份信息的认证。所以需要在 Spring Security 的过滤器链中添加 JWT 过滤器。

在 [SpringSecurityConfig.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/config/SpringSecurityConfig.java) 的 `#configure(HttpSecurity httpSecurity)` 方法中添加 [JwtAuthenticationTokenFilter.java](https://github.com/Deecyn/mall_learn/blob/master/mall_learn_13/src/main/java/deecyn/mall_learn_13/component/JwtAuthenticationTokenFilter.java) 过滤器，代码如下：

```java
/** 对 HttpSecurity 进行配置，配置路径及资源的访问权限  */
@Override
public void configure(HttpSecurity httpSecurity) throws Exception {
    // 省略其它代码的展示···
  
    // 添加 JWT 过滤器
    httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), 
            UsernamePasswordAuthenticationFilter.class);
    // ····
}

@Bean
public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
    return new JwtAuthenticationTokenFilter();
}
```

HttpSecurity 有三个常用的添加过滤器的方法：

- `addFilterBefore(Filter filter, Class<? extends Filter> beforeFilter)` 方法，在 beforeFilter 之前添加 filter 。
- `addFilterAfter(Filter filter, Class<? extends Filter> afterFilter)` 方法，在 afterFilter 之后添加 filter 。
- `addFilterAt(Filter filter, Class<? extends Filter> atFilter)` 方法，在与 atFilter 位置相同的地方添加 filter， 新添加  filter 不会覆盖原先的 atFilter 。对于这些位置相同的 Filter，他们执行的先后顺序是不确定的。

-----

（完）