package com.valtech.training.simpleintrest;

import org.Arthmetic.ArthmeticImpl;

import com.valtech.training.Arthmetic;

public class SimpleIntrestImpl implements SimpleIntrest {
	private Arthmetic arthmetic=new ArthmeticImpl();

	
	public int computeIntrest(int prin,int roi,int time) {
		return arthmetic.div(arthmetic.mul(prin,arthmetic.mul(roi,time) ),100);
		
	}
}
