package com.twu.massagem.service;

import com.twu.massagem.model.MassageDay;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class DiaMassagemService {

    @Autowired
//    private DiaMassagemRepository diaMassagemRepository;

    public void salvarDiaMassagem(int quantidade, List<LocalDate> datas, String tipoDeMassagem){

        MassageDay dia = new MassageDay();

       // List<MassageDay> listaDiasDeMassagem = dia.insereDiaDeMassagem(quantidade, datas, tipoDeMassagem);

        //for (int i = 0; i < listaDiasDeMassagem.size(); i++) {
         //   diaMassagemRepository.save(listaDiasDeMassagem.get(i));
        //}
    }



}
