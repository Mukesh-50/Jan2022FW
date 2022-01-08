package com.learnautomation.testing;

import com.github.javafaker.Faker;

public class FakerDemo {

	public static void main(String[] args) {
		
		Faker fake=new Faker();
		System.out.println(fake.name().firstName());
		System.out.println(fake.address().cityName());
		System.out.println(fake.book().author());
		System.out.println(fake.number().randomDigit());
		
	}
	
}
