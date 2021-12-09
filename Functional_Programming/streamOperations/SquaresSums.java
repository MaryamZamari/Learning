package streamOperations;

import java.util.List;

public class SquaresSums {

	public static void main(String[] args) {
		
		List<Integer>numbers= List.of(12,9, 13,4, 6,2, 4, 12, 15); 
		
		squares(numbers); 
		cubes(numbers); 
		sumOfOdds(numbers);
		distinct(numbers);
		sorted(numbers); 
	}

	
	
	private static void squares(List<Integer> numbers) {
		//with stream we loop through elements, internally
		int sum = numbers.stream()
		.map(number -> number * number)
		.reduce(0, Integer :: sum);

		System.out.println("sum of squares is : " + sum);
				
	}
	
	private static void cubes(List<Integer>numbers) {
		
		int sum= numbers.stream()
		.map(number -> number * number * number)
		.reduce(0,  Integer :: sum); 
		
		System.out.println("the sum of cubes is : " + sum);
	}
	
	
	private static void sumOfOdds(List<Integer>numbers) {
		
		int sum = numbers.stream()
		.filter(a -> a % 2 != 0)
		.reduce(0, Integer :: sum);
		 System.out.println("sum of odds is : "+ sum);
		
	}
	
	private static void distinct(List<Integer>numbers) {
		System.out.println("The distinct numbers of the list are : \n");
		numbers.stream().distinct().forEach(System.out :: println);
			}

	private static void sorted(List<Integer>numbers) {
		System.out.println("The sorted list : \n");
		numbers.stream().sorted().forEach(System.out :: println);
			}
	
	
}
