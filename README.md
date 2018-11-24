# spb-thymeleaf-login
项目主要功能就是登录，实现页面跳转

包含spb,thymeleaf,bootstrap,jquery等技术点

一、整体请求流

项目启动后：

1、网页输入：localhost:8080,对应后端controller中配置了，@RequestMapping("/")的
IndexController类中的，index方法

2、index方法中，返回字符串 index,在thymeleaf的默认配置中，默认前缀是：classpath:/templates/
默认后缀是 .html,所以，前端会返回在templates目录下的 index.html文件

3、index.html文件中，html中定义了form，action是login,方法是post
<form ... action="login" method="post" id="loginform">

在index.html中，引入jquery,其中有$("#loginform").submit();就会把index的页面连同id为
loginform的参数，提交到 请求方法为post,action我login的controller,既注解为
@PostMapping("login") 的LoginController类的login方法

4、login方法中，通过@RequestParam("loginName") String loginName取到请求的参数，简单demo并未进行密码校验。
直接将请求通过mv.setViewName("redirect:/main");重定向到路径为 "/main"的controller,
此处注意，重定向是将请求跳转到对应controler,而返回字符串是直接返回html页面

5、注解为@RequestMapping(value="/main")的MainController类的main方法，处理跳转请求，直接返回字符串main,
既页面返回 templates/main.html页面

二、变量从html、js和controller之间的传递
以登录名为例，为区分变量，对源码进行了修改

1、在index.html的form表单中，
 placeholder="用户名/邮箱" type="text" name="loginNameRequestParm" id="loginNameId" />
用户名的输入框，name="loginNameRequestParm" id="loginNameId" id和name的值如下：
其实，name是传递到controller的变量表示，id是js使用的变量表示

2、index.html的js中，
var loginNameJsVar = $("#loginNameId");
通过控件id拿到变量，拿到的var在js使用，
    if(loginNameJsVar.val() == ""){ 为拿到变量值 

    loginNameJsVar.focus(); 让控件占据输入焦点
    
3、在对应的controller中，用
@RequestParam("loginNameRequestParm") String loginNameJavaVar,
通过变量name拿到变量值，这个是定义的java普通变量，在controller的方法中使用



三、零碎知识点

1、thymeleaf的引入
html页面中加入
<html xmlns:th="http://www.thymeleaf.org">

2、bootstrap核心思想：网格系统。在本项目main.html项目中，实现排版。
如：<div class="col-md-4 col-sm-6"> 这些

3、jquery处理页面提交请求
在index.html中
引入： <script type="text/javascript" th:src="@{js/jquery-1.11.0.min.js}"></script>
使用：$(function(){...,用来提交页面请求

4、spb中，@RequestMapping，@PostMapping的区别

@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。 

@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。

RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径

参考：https://blog.csdn.net/walkerJong/article/details/7994326


