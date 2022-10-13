package com.valtech.training.valtech.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;




public class ArithmeticTest {
	private static Arthmetic arthmetic;
	private  static int ZERO;
	
	
	
	
	@org.junit.jupiter.api.Nested
	@DisplayName("This is for testing sub method of Airthmetic")
	
	public  class SubtractionTest{
		
		@DisplayName("{index} {0} {1} + {2} ={3}")
		@ParameterizedTest
		@CsvSource({
			
			"'Adding 2 +ve num',3,2,1",
			
		})
		public void testSub(String name,int a,int b,int res) {
			
			arthmetic =new ArthmeticImpl();
			assertEquals(res, arthmetic.sub(a,b));
			
		}
		
		
		@Test
		public void testzero(){
			arthmetic =new ArthmeticImpl();
			assertThrows(ArithmeticException.class,() -> {arthmetic.div(2,ZERO);});
		}
	
	}
	
	
	
	
	public static Stream<Arguments> argumentsForAdd(){
		return Stream.of(Arguments.of(2,3,5),Arguments.of(2,3,5));
		
	}
	
	@ParameterizedTest
	@MethodSource("argumentsForAdd")
	public void testAdd(int a,int b,int c){
		
	}
	
	
	
	
	
	
	@DisplayName("{index} {0} {1} + {2} ={3}")
	@ParameterizedTest
	@CsvSource({
		
		"'Adding 2 +ve num',2,3,5",
		
	})
	public void testAdd(String name,int a,int b,int res) {
		assertEquals(res, arthmetic.add(a,b));
		
	}
	
	
	@ParameterizedTest
	@ValueSource(ints={2,3,4,-1,-2})
	@DisplayName(value="{index} Testing for add with {0} and 0")
	public void testAdd(int a){
		
		assertEquals(a, arthmetic.add(a, 0));
	}
	
	
	
	@BeforeAll
	public static void executeMeFirst(){
		System.out.println("Before All");
		ZERO=0;
	}
	@AfterAll
	public static void executeMeLast(){
		System.out.println("After All");
		
	}
	
	
	
	
	
	
	
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
