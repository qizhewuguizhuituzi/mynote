package com.zcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*SpringMVC实现转发和重定向
* */
@Controller
public class RedirectAndForwardController {
    @RequestMapping("/redirect")
    public String redirect(Model model){
        /*记录一个问题 使用redirect的时候不能重定向的WEB-INF下的jsp*/
        return "redirect:/index.jsp";
    }

    @RequestMapping("/forward")
    public String forward(Model model){
        model.addAttribute("msg","springMVC实现转发");
        return "t2";
    }
}
