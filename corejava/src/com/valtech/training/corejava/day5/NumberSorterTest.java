package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class NumberSorterTest {

	@Test
	public void test() {
		Integer [] data=new Integer [] {57,32,46,-1,71,1};
		Arrays.sort(data,new NumberSorter());
		assertArrayEquals(new Integer [] {-1,1,57,71,46,32},data);
	}

	

}
