package functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterface {
	/*
	 * boolean isEven (int x)
	 * return x % 2 == 0 ; 
	 * 
	 * int squared(int x){
	 * return x * x; 
	 * } 
	 * 
	 */

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9 , 13, 4, 6, 2, 4, 12, 15);
		
		//right click on what you wrote in the filter and map --> refactor --> local variable 
		//as you see, there are some other classes behind our lambda expressions
		//predicate is a Functional Interface --> an interface with only one ABSTRACT method
		//(other methods of the interface are default or static and are developed)
		//ctrl + click --> definition 
		//==================================================================
		
		//these are the things happening behind lambda expression
		
		
		//PREDICATE
		//the code behind the line above using Predicate Interface
				//lambda expression is presented like an object 
				
				//Predicate is usually used to TEST something. the return type is boolean 
				// so the logic is written based on a boolean to check 
				Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {

					@Override
					public boolean test(Integer x) {

						return x % 2 == 0;
					}
					
				};
				
		Predicate<? super Integer> isEvenPredicate = x -> x % 2 ==0;
		//-----------------------------------------------------------------------------------
		
		//FUNCTION
		//gets an input and produces output(result)
		Function<? super Integer, ? extends Integer> squareFunction = x -> x * x;
		
		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>(){

			@Override
			public Integer apply(Integer x ) {
				return x * x;
			}
			
		};
		
		
		//----------------------------------------------------------------------
		//CONSUMER
		//it consumes what is given (like a scanner) 
		Consumer<Integer> sysoutConsumer = System.out :: println;
		
		Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {

			@Override
			public void accept(Integer x) {

				System.out.println(); 
				
			}
			
		};
		
		
		
		
		//=========================================================================
		numbers.stream()
		.filter(isEvenPredicate) 
		.map(squareFunction)  // lambda expression 
		.forEach(sysoutConsumer); //--> static method reference
		// .forEach(x -> System.out.println(x))
	}

}
