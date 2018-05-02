package com.twu.massagem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/massagem")

public class DiaController {

    @RequestMapping("/home")
    public String home(){

        return "/DiaMassagemView.html";
    }




}

