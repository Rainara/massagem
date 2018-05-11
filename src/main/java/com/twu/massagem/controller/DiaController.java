package com.twu.massagem.controller;


import com.twu.massagem.model.MassageDay;
import com.twu.massagem.validation.MassageValidation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/massagem")

public class DiaController {
    //@Autowired
    //private DiaDeMassagemRepository diaDeMassagemRepository;

    @RequestMapping("/home")
    public String home(){
        return "/DiaMassagemView.html";
    }

    @GetMapping(path="/criarMassagem")
    public @ResponseBody String adicionarNovaMassagem (@RequestParam int quantity
            , @RequestParam List<LocalDate> dates, @RequestParam String massageType) {

        ModelAndView mv = new ModelAndView("redirect:/");



        MassageValidation massageValidation = new MassageValidation(dates,quantity);

        if(massageValidation.isTheInputGivenValidated()){
            for (int i=0;i<dates.size();i++){

            }
        }

        return "saved";
    }



}

