package org.Arthmetic;

import org.junit.Test;

import com.valtech.training.Arthmetic;

import static org.junit.Assert.*;

import org.junit.Test;



public class ArthmeticImplTest  {
	@Test
	public void addtest() {
		Arthmetic a=new ArthmeticImpl();
		assertEquals(5, a.add(2, 3));
		assertEquals(5, a.add(3, 2));
		assertEquals(3, a.add(0, 3));
	
	}
	@Test
	public void subtest() {
		// TODO Auto-generated method stub
		Arthmetic a=new ArthmeticImpl();
		assertEquals(5, a.sub(7, 2));
		assertEquals(6, a.sub(9, 3));
		assertEquals(10, a.sub(14, 4));
	}
	@Test
	public void multest() {
		// TODO Auto-generated method stub
		Arthmetic a=new ArthmeticImpl();
		assertEquals(6, a.mul(3, 2));
		assertEquals(9, a.mul(3, 3));
		

	}
	@Test
	public void divtest() {
		// TODO Auto-generated method stub
		Arthmetic a=new ArthmeticImpl();
		assertEquals(5, a.div(20, 4));
		;
	}

}
