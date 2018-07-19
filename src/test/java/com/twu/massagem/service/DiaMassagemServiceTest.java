package com.twu.massagem.service;

import com.twu.massagem.model.MassageDay;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class DiaMassagemServiceTest {

    private DiaMassagemService diaMassagemService;
    //private DiaMassagemRepository diaMassagemRepository;
    private MassageDay massageDay;


    @Before
    public void createMock() {
        diaMassagemService = mock(DiaMassagemService.class);
     //   diaMassagemRepository = mock(DiaMassagemRepository.class);

        massageDay = new MassageDay();
    }

    @Test
    public void deveSalvarDiaDeMassagemQuandoOsDadosForemValidos() {

        //when(diaMassagemService.salvarDiaMassagem(2,datas,"Normal")).thenReturn()

        List<LocalDate> datas = new ArrayList<>();

        datas.add(LocalDate.parse("2018-08-16"));
        datas.add(LocalDate.parse("2018-08-17"));



        ;


        //Mockito.verify(diaMassagemRepository,times(2)).save(massageDay);


    }





}