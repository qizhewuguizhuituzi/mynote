package com.zcb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestFullController {
    @GetMapping("/{a}")
    public String get(@PathVariable int a){
        return "get";
    }

    @PostMapping("/post")
    public String post(@RequestParam("name") String name,@RequestParam("password") String password, Model model){
        model.addAttribute("msg",name+password);
        return "post";
    }
    @PutMapping("/put")
    public String put(@RequestParam("name") String name){
        return "put";
    }
    @DeleteMapping("/delete")
    public ModelAndView delete(int id,ModelAndView model){
        model.addObject("delete",id);
        model.setViewName("delete");
        return model;
    }
}
