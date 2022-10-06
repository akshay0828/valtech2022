package com.valtech.training.corejava.day4;

public class Threads {
	
	static class TrestRunable implements Runnable{
		public void run () {
			for (int i = 0; i < 10; i++) {
	System.out.println(Thread.currentThread()+""+i);			
			}
		}
	}
	
	public static void main(String[] args) {
		
	 new Thread(new TrestRunable()).start();
	 new Thread(new TrestRunable()).start();
	 
	 new Thread(()-> {
		 for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread()+""+i);			
						} 
	 }).start();
	 
	 for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread()+""+i);			
					}
	}

	}
