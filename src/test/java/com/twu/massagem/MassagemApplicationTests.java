package com.twu.massagem;

import com.twu.massagem.controller.DiaController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MassagemApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void naoDeveAceitarQuantidadeZero(){
		DiaDeMassagem validaDia = new DiaDeMassagem();
        List<LocalDate> datas = new ArrayList<>();
		assertFalse(validaDia.validarData(datas,0));
	}

	@Test
	public void conjuntoDeDatasNaoDeveSerVazio(){

		DiaDeMassagem validaDia = new DiaDeMassagem();
		List<LocalDate> datas = new ArrayList<>();
				assertFalse(validaDia.validarData(datas,2));

	}

	@Test
	public void deveAceitarApenasDatasDiferentes(){

		DiaDeMassagem validaDia = new DiaDeMassagem();
		List<LocalDate> datas = new ArrayList<>();

		datas.add(creteDateFromPattern("2016-08-16"));
		datas.add(creteDateFromPattern("2016-08-16"));
		datas.add(creteDateFromPattern("2016-08-16"));

		assertEquals(2,validaDia.contarDatasDuplicadas(datas));
		assertFalse(validaDia.validarData(datas,3));

	}

	@Test
	public void numeroDeDatasDeveSerCorrespondenteAQuantidade(){

		DiaDeMassagem validaDia = new DiaDeMassagem();
		List<LocalDate> datas = new ArrayList<>();

		datas.add(creteDateFromPattern("2016-08-16"));
		datas.add(creteDateFromPattern("2016-08-17"));
		datas.add(creteDateFromPattern("2016-08-18"));

		assertFalse(validaDia.validarData(datas,2));
		assertTrue(validaDia.validarData(datas,3));
	}

	@Test
	public void diasDeMassagemDevemTerMesmoTipo(){

		DiaDeMassagem validaDia = new DiaDeMassagem();
		List<String> resultado = new ArrayList ( Arrays.asList("Especial","Especial","Especial"));

		assertEquals(resultado,validaDia.verificaTipo(3,"Especial"));

	}

	@Test
	public void deveAceitarDatasApenasAPartirDoPresente(){
		DiaDeMassagem validaDia = new DiaDeMassagem();
		List<LocalDate> datas = new ArrayList<>();

		datas.add(creteDateFromPattern("2016-08-16"));
		datas.add(creteDateFromPattern("2016-08-16"));
		datas.add(creteDateFromPattern("2016-08-16"));
		datas.add(creteDateFromPattern("2016-08-16"));

		assertFalse(validaDia.verificaData(datas));
	}

	private LocalDate creteDateFromPattern(String date) {
		return LocalDate.parse(date);
	}

	@Test
	public void deveRealizarInsercaoQuandoEntradaForValida(){

	    DiaDeMassagem diaDeMassagem = new DiaDeMassagem();

        List<LocalDate> datas = new ArrayList<>();

        datas.add(creteDateFromPattern("2018-05-16"));
		datas.add(creteDateFromPattern("2018-05-17"));

        List<DiaDeMassagem> diasDeMassagem = new ArrayList(Arrays.asList(new DiaDeMassagem(0, datas.get(0),"Especial"),
				new DiaDeMassagem(1,datas.get(1), "Especial")));
		List<DiaDeMassagem> diasDeMassagemEntrada = diaDeMassagem.insereDiaDeMassagem(2, datas,"Especial");


        assertEquals(diasDeMassagem.get(0).getId(),diasDeMassagemEntrada.get(0).getId());
		assertEquals(diasDeMassagem.get(0).getData(),diasDeMassagemEntrada.get(0).getData());
		assertEquals(diasDeMassagem.get(0).getTipoDeMassagem(),diasDeMassagemEntrada.get(0).getTipoDeMassagem());
		assertEquals(diasDeMassagem.get(1).getId(),diasDeMassagemEntrada.get(1).getId());
		assertEquals(diasDeMassagem.get(1).getData(),diasDeMassagemEntrada.get(1).getData());
		assertEquals(diasDeMassagem.get(1).getTipoDeMassagem(),diasDeMassagemEntrada.get(1).getTipoDeMassagem());
	}

	@Test
	public void deveRetornarVazioEmInsercaoInvalida(){

		DiaDeMassagem diaDeMassagem = new DiaDeMassagem();
		List<DiaDeMassagem> diasDeMassagem= new ArrayList<>();

		List<LocalDate> datas = new ArrayList<>();

		datas.add(creteDateFromPattern("2018-04-16"));
		datas.add(creteDateFromPattern("2018-04-17"));

		List<DiaDeMassagem> diasDeMassagemEntrada = diaDeMassagem.insereDiaDeMassagem(3,datas,"Especial");

		assertEquals(diasDeMassagem, diasDeMassagemEntrada);


	}


}
