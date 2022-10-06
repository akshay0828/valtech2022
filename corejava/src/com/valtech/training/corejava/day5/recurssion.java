package com.valtech.training.corejava.day5;

import java.util.ArrayList;
import java.util.List;

public class recurssion {
	static List<Long> factorials=new ArrayList<>();;


	public static long foctorial(int n) {
		//long result1=this.result;
		if(n==0) {
			factorials.add((long) 0);
			return 1;
		}
		else if(n==1) {
			factorials.add((long) 1);
			return 1;
		}
		else if(factorials.size()>n) {
			return factorials.get(n-1);
		}
		else if(factorials.size()>=n)
			return factorials.get(n-1);
			
		else {
			
			  long fact = foctorial(n-1);
			  factorials.add(n*fact);
			  long factn=n*fact;
			
		       return factn; 
		}
	}
	
	public static void main(String[] args) {
		recurssion f=new recurssion();
		System.out.println(f.foctorial(9));

}
}


