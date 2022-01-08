package com.learnautomation.testing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		Date d=new Date();
		
		System.out.println(d);
		
		SimpleDateFormat dateformat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		
		System.out.println(dateformat.format(d));
		

	}

}
