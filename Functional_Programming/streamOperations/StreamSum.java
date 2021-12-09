package streamOperations;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSum {

	public static void main(String[] args) {

		List<Integer>numbers= List.of(12,9, 13,4, 6,2, 4, 12, 15); 
		
		//creating another list out of our list 
		List<Integer> doubledNumbers = doubleList(numbers);
		// 1, 5, 6 
		// 1 -> 1
		//5 -> 25
		//6 -> 36
		
		
		
		int sum = addListStructured(numbers); 
		System.out.println(sum);
	
		int sumF = addListFunctional(numbers); 
		System.out.println(sumF);
	
		doubleList(doubledNumbers); 
		//int sum1= sumFunctional(numbers);
		//System.out.println(sum1);
		
		List<Integer> evenNumbersOnly = numbers.stream().
				filter(number -> number %2 ==0).collect(Collectors.toList());
		System.out.println(evenNumbersOnly );
		
		
	}

	

	//how to loop? 
	//how to store the sum? 
	private static int addListStructured(List<Integer> numbers) {
		int sum = 0 ; 
		
		for(int number: numbers) {
			
			sum += number; 
		}
		
		return sum;
	}

	
	//functional : what to do?
	
	private static int sum(int a , int b) {
		return a+ b; 
	}
	
	
	private static int addListFunctional(List<Integer> numbers) {
		//to get a number at a time 
		//combine all them into one result => ONE VALUE
		// 0 and sum (a,b) -> a + b ----------> a reduce operation two into one
		 
		return numbers.stream()
	//	.reduce(0, StreamSum :: sum); // using method reference and a static method
	//	.reduce(0, (x,y) -> x+y);  //lambda expression
	//	.reduce(Integer.MAX_VALUE , (x,y) -> (x<y)? x:y) ----> find minimum in list  
		.reduce(0,  Integer :: sum); 
	}
	
	private static int sumFunctional(int aggregate , int nextNumber) {
		System.out.println(aggregate + " " + nextNumber);
		return aggregate  + nextNumber; 
	}
	
	private static List doubleList(List<Integer> numbers) {
		return numbers.stream().map(number -> number * number).collect(Collectors.toList());
	}
}
