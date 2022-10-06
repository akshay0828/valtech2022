package com.valtech.training.corejava.day4;

public class Arithmetic<E> {
public String add(E a,E b) {
	return a.toString()+b.toString();
}
public static void main(String[] args) {
	Arithmetic<Integer> a= new Arithmetic<>();
	System.out.println(a.add(2, 3));
	System.out.println(new Arithmetic<Double>().add(2.3, 4.6));
}
}
