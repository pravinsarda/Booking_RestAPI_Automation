package com.tc.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

import com.github.javafaker.Faker;

public class TestData {

	public Faker faker;

	public TestData() {
		faker = new Faker(new Locale("en-IND"));
	}

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getDate(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(faker.date().birthday());
	}


}
