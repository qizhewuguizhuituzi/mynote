package com.zcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*通过设置ServletAPI,是不需要视图解析器的*/
@Controller
@RequestMapping("/servlet")
public class ServletController {
    @RequestMapping("/t1")
    public void t1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().print("hello,Spring by Servlet API");
    }


    @RequestMapping("/t2")
    public void t2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //重定向
        resp.sendRedirect("/index.jsp");
    }

    @RequestMapping("/t3")
    public void t3(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //转发
        req.setAttribute("msg","t3");
        req.getRequestDispatcher("/WEB-INF/jsp/t1.jsp").forward(req,resp);
    }

}
