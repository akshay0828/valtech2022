package com.valtech.training.valtech.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArithmeticTest {
	private Arthmetic arthmetic;
	@BeforeEach
	public void runBefore() {
		arthmetic =new ArthmeticImpl();
		System.out.println("Run Bfore..");
	}
	
	@AfterEach
	public void runAfter() {
		arthmetic =new ArthmeticImpl();
		System.out.println("Run After..");
	}
	
	@Test
	public void testHi() {
		System.out.println("hi");
	}

	@Test
	public void testHello() {
		System.out.println("hello");
	}

}
