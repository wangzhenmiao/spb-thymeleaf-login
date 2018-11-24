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

