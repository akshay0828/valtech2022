package com.valtech.training.corejava.day5;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SortStringTest {

	   @Test
	    public void testLength() {
	        String[] names= {"Abc","Pqr","Lmno","Ab","z"};
	        Arrays.sort(names, new SortString());
	        assertArrayEquals(new String[] {"z","Ab","Abc","Pqr","Lmno"},names);
	    }
	    
	    @Test
	    public void testVowelCount() {
	        String[] names= {"Abc","Pqr","Lmno","Ab","z","a"};
	        Arrays.sort(names, new SortString());
	        assertArrayEquals(new String[] {"a","z","Ab","Abc","Pqr","Lmno"},names);
	    }
	    
	    @Test
	    public void testAlphabeticOrder() {
	        String[] names= {"Abc","Pqr","Lmno","Too","Abz","z"};
	        Arrays.sort(names, new SortString());
	        assertArrayEquals(new String[] {"z","Abc","Abz","Pqr","Too","Lmno"}, names);
	    }



	}