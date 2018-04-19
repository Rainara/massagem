package com.twu.massagem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MassagemApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void deveCriarATabelaDiaDaMassagemComSucesso(){

		DiaDeMassagem diadeMassagem = new DiaDeMassagem
			(1, "03-04-2018", "Convencional");


		assertEquals(diadeMassagem,diadeMassagem);


	}



}
