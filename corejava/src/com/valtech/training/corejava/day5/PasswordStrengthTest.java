package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;



public class PasswordStrengthTest {

	@Test
	public void test() {
		
		 PasswordStrength p =new PasswordStrength();
	String Stronginput="Password@12#23";
	String Weakinput="Passwor@123";
		 boolean score=p.check(Stronginput);
		 
		//assertEquals(true, score);
		assertEquals(true,p.check(Stronginput));
		assertEquals(false,p.check(Weakinput));
		assertEquals(7,p.isChar(Stronginput));
		assertEquals(5,p.isChar(Weakinput));

		
			
	}

}
