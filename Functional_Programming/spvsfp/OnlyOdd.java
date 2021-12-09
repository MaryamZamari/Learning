package spvsfp;

import java.util.List;

public class OnlyOdd {

	//structural
	public static void printOnlyOddStructural(List<Integer> numbers) {
		
		for(int number: numbers) {
			if(number %2 != 0) {
				System.out.println(number);
			}; 
		}
		
	}
	
	public static void printOnlyOddFunctional1(List<Integer>numbers) {
		numbers.stream()
		//lambda : parameter -> condition 
		.filter(number -> number %2 != 0)
		.map(number -> number * number * number )
		.forEach(System.out:: println); 
	}
	
	
	public static void main(String[] args) {

		printOnlyOddStructural(List.of(1,3,11,18,19));
		
		printOnlyOddFunctional1(List.of(1,3,11,18,19));
		
		
		
		
		
		
	}

}
