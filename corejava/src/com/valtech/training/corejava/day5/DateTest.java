package com.valtech.training.corejava.day5;


import java.util.Calendar;
import java.util.Date;
import java.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class DateTest {
	
	
	//System.out.println(df.format(date));
	@Test
	public void testDate() {
		Date date =new Date();
		//System.out.println(date);
	}
		@Test
		public void testDateOldway() {
			Date date =new Date(47,7,15);
			//System.out.println(date);
		}
			
			@Test
			public void testDateWithCal() {
				Calendar cal=Calendar.getInstance();
				cal.set(Calendar.YEAR, 1947);
				cal.set(Calendar.MONTH, 7);
				cal.set(Calendar.DATE, 15);
				
				//System.out.println(cal);
	
				Date date =new Date(47,7,15);
				//System.out.println(date);
			}
			
			@Test
			public void testDateFromString() throws Exception {
				DateFormat df =new SimpleDateFormat("dd-MM-yyyy");
				Date date=df.parse("15-08-1947");
				System.out.println(date);}
		
	}


