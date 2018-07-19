package com.twu.massagem;

import com.twu.massagem.model.MassageDay;
import com.twu.massagem.validation.MassageValidation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MassagemApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldNotAcceptQuantityZero(){

		List<LocalDate> dates = new ArrayList<>();
		dates.add(LocalDate.parse("2016-08-16"));
		dates.add(LocalDate.parse("2016-08-17"));
		dates.add(LocalDate.parse("2016-08-18"));

		MassageValidation massageValidation = new MassageValidation(dates,0);
		assertFalse(massageValidation.isEqualQuantityAndInformedDates());
	}

	@Test
	public void shouldNotAcceptEmptyDateList(){

		List<LocalDate> dates = new ArrayList<>();
		MassageValidation massageValidation = new MassageValidation(dates,0);
		assertFalse(massageValidation.isEqualQuantityAndInformedDates());

	}

	@Test
	public void shouldAcceptOnlyDifferentDatesInTheList(){


		List<LocalDate> dates = new ArrayList<>();

		dates.add(LocalDate.parse("2016-08-16"));
		dates.add(LocalDate.parse("2016-08-16"));
		dates.add(LocalDate.parse("2016-08-16"));

		MassageValidation massageValidation = new MassageValidation(dates,3);
		assertEquals(2,massageValidation.countDuplicatedDates());
		assertFalse(massageValidation.isEqualQuantityAndInformedDates());

	}

	@Test
	public void listSizeShouldBeEqualToQuantity(){

		MassageDay validaDia = new MassageDay();
		List<LocalDate> dates = new ArrayList<>();

		dates.add(LocalDate.parse("2016-08-16"));
		dates.add(LocalDate.parse("2016-08-17"));
		dates.add(LocalDate.parse("2016-08-18"));

		MassageValidation massageValidation = new MassageValidation(dates,3);
		assertTrue(massageValidation.isEqualQuantityAndInformedDates());
	}

	@Test
	public void shouldNotAcceptPastDates(){
		MassageDay validaDia = new MassageDay();
		List<LocalDate> dates = new ArrayList<>();

		dates.add(LocalDate.parse("2015-08-16"));
		dates.add(LocalDate.parse("2014-08-16"));
		dates.add(LocalDate.parse("2013-08-16"));
		dates.add(LocalDate.parse("2012-08-16"));

		MassageValidation massageValidation = new MassageValidation(dates,4);

		assertFalse(massageValidation.isTheDateInAnAcceptableRange());
	}

	private LocalDate creteDateFromPattern(String date) {
		return LocalDate.parse(date);
	}

	@Test
	public void shouldReturnTrueWhenDatesAndQuantityAreValid(){

		List<LocalDate> dates = new ArrayList<>();

		dates.add(LocalDate.parse("2018-08-16"));
		dates.add(LocalDate.parse("2018-08-17"));
		dates.add(LocalDate.parse("2018-08-18"));
		dates.add(LocalDate.parse("2018-08-19"));

		MassageValidation massageValidation = new MassageValidation(dates,4);

		assertTrue(massageValidation.isTheInputGivenValidated());

	}




}
