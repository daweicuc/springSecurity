package cuc.dawei.springsecuritydemo.controller;

import cuc.dawei.springsecuritydemo.entity.MsgSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author Mike
 * @Date 2019/8/19 20:07
 * @Version 1.0
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){
        MsgSecurity msg=new MsgSecurity("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        System.out.println("controller1111");
        return "home";
    }
    @RequestMapping("/login")
    public String login(){
        System.out.println("登陆login页面");
        return "login";
    }
    @RequestMapping("/index")
    public String index1(){
        System.out.println("登陆index页面");
        return "index";
    }
    @RequestMapping("/user/list")
    public String list1(){
        return "userlist";
    }
    @RequestMapping("/role/list")
    public String list2(){
        return "rolelist";
    }

    @RequestMapping("/menu/list")
    public String list3(){
        return "menulist";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "useradd";
    }
    @RequestMapping("/user/update")
    public String update(){
        return "userupdate";
    }
    @RequestMapping("/user/del")
    public String del(){
        return "userdel";
    }

    @RequestMapping("/404")
    public String to404()  {
        return "404";
    }
    @RequestMapping("/403")
    public String to403()  {
        return "403";
    }
    @RequestMapping("/500")
    public String to500()  {
        return "500";
    }


}
