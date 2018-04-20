package com.twu.massagem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/teste")
public class DiaController {


    @GetMapping(path="/add")
    public @ResponseBody String index() {

        return "oi sumido!!!";
    }
}
