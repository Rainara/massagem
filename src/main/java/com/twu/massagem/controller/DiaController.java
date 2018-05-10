package com.twu.massagem.controller;


import com.twu.massagem.model.MassageDay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody String adicionarNovaMassagem (@RequestParam int quantidade
            , @RequestParam List<LocalDate> dias, @RequestParam String tipoDeMassagem) {

        MassageDay dia = new MassageDay();

       //List<MassageDay> listaDiasDeMassagem = dia.insereDiaDeMassagem(quantidade, dias, tipoDeMassagem);

       //for (int i = 0; i < listaDiasDeMassagem.size(); i++) {
            //diaDeMassagemRepository.save(listaDiasDeMassagem.get(i));
       // }

        return "saved";
    }



}

