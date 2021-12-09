package spvsfp;

import java.util.List;

public class SpVsFp {
//u hava a list of numbers and u want to print them one by one
	
	public static void main(String[] args) {

		printAllNumbersInListStructured(List.of(12,9,13,4,6,2,12,15));
		
		
	}
	
	private static void print(int number) {
		System.out.println(number);
	}

private static void printAllNumbersInListStructured(List<Integer> numbers) {
	
	
	//Structured programming
	// how to loop numbers? 
	for(int number:numbers) {
		System.out.println(number);
		
	
	
	//Functional Approach	
	//what to do ? 
	//we have to first convert the numbers, in a STREAM of numbers (sequence of elements)
	//then we use a method reference
	//METHOD REFERENCE : to define the behavior of each element (for each element we want to run the print method that we defined beffore)
	//we use always :: for Method references 	
	
	
	numbers.stream()
	.forEach(SpVsFp:: print); //synthax of method reference . says the method belongs to this class
	
	//simpler
	numbers.stream()
	.forEach(System.out :: println);
	}
	
}
}
