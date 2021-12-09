

package spvsfp;

import java.util.List;

public class SpvsFp02EvenNumbers {

	
	//functional programming 
	//here using FILTERS, i can choose to only see Even numbers 
	private static boolean isEven(int number) {
		return number%2 == 0; 
	}
	
	private static void printAllEvenNumbersFunctional(List<Integer>numbers) {
		
		numbers.stream()
		//only allow Even numbers
		.filter(SpvsFp02EvenNumbers :: isEven)
		.forEach(System.out :: println); // method reference
		
	}
	
	private static void printAllEvenNumbersFunctionalLambda(List<Integer>numbers) {
	//simpler way: Lambda expression. a method that makes it simpler
			//take number as parameter, and check if it is even and return it back
			//in lambda expression, if there is only 1 expression, it will return the value back 
			numbers.stream()
			.filter(number -> number %2 == 0)
			.forEach(System.out :: println);//with methd reference u are refering to a method that is defined somewhere else
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,12,15);
		
		printAllEvenNumbersInListStructured(numbers);
	}

	private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
	//structured programming
	//how to loop numbers? how to find even?
	for(int n : numbers) {
		if(n % 2 == 0 ) {
			System.out.println(n);
		}
	}
		
	
	//functional --> filters 
	//what to do

	 
	
	
	
	
	}

}
