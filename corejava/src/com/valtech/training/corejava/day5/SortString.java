package com.valtech.training.corejava.day5;

import java.util.Comparator;

public class SortString implements Comparator<String>  {
	
	
	private int vowelCount(String s3) {
        String vowels = "AaEeIiOoUu";
        int count =0;
        for(int i =0 ;i<s3.length(); i++) {
            char s4 = s3.charAt(i);
            if(vowels.contains(""+s4)) {
                count++;
            }
        }
        return count;
        }
	public int Alpha(String s1,String s2){
		
		return s1.compareTo(s2) ;
	}
	@Override
    public int compare(String s1, String s2) {
		int l1=s1.length();
		int l2=s2.length();

        
        if(l1<l2) return -1;
        if(l1>l2) return +1;
        
        l1=vowelCount(s1);
        l2=vowelCount(s1);
        
        if(l1<l2) return -1;
        if(l1>l2) return +1;
        return s1.compareTo(s2);
        
        
    }
	
}
