package com.valtech.training.corejava.day5;

public class PasswordStrength {
	
	


    
	private int issmall(String a) {
		
		
		if( a.matches("(?=.*[a-z]).*") ) {
	      return 5;	
		}
		return 0;
	}
	private int isUpper(String a) {
		if( a.matches("(?=.*[A-Z]).*") ) {
	      return 5;	
		}
		return 0;
	}
	public int isNum(String a) {
		
		int digi = 0;int flag=0;
	
		if( a.matches("(?=.*[0-9]).*")  ) {
			
			flag=0;
			for(int i = 0; i < a.length(); i++)
			{
				int ch = a.charAt(i);
				if(ch >= '0' && ch <= '9') {
					if(flag==0) {
					digi=5; flag=1;}
					else {
						digi++;
					}
				}
			
			}
	      return digi;	
		}
		
		return 0;
	}
	
	public int isChar(String a) {
		int alph = 0;int digi = 0;int spl = 0,flag=0;
		if( a.matches("(?=.*[~!@#$%^&*()_]).*") ) {
			for(int i = 0; i < a.length(); i++)
			{
				int ch = a.charAt(i);
				if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' ) {
					alph++;
				}
				else if(ch >= '0' && ch <= '9') {
					digi++;
				}
				else if(flag==0) {
					spl+=5;flag=1;
					}
					else {
					spl+=2;
					}
					
			
			}	
			System.out.println(spl);
	      return spl;	
		}
		return 0;
	}
	public boolean check(String a) {
		
		int b1 = issmall(a);
		int b2 =isUpper(a);
		int b3 =isNum(a);
		int b4 =isChar(a);
		//System.out.println(b1+b2+b3+b4);
		
		
		int total= b1+b2+b3+b4;
		System.out.println(total);
		
		if(total>=25) {
			return true;
		}
		return false;
		
	}
	
	
	
}