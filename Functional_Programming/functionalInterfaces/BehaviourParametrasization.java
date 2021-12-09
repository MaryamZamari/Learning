package functionalInterfaces;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviourParametrasization {

	public static void main(String[] args) {

		List<Integer>numbers= List.of(12,9, 13,4, 6,2, 4, 12, 15);
		
		Predicate<? super Integer> isEvenPredicate = x -> x % 2 == 0;
		filterAndPrint(numbers, isEvenPredicate);
		
		
		
		Predicate<? super Integer> isOddPredicate = x -> x % 2 != 0;
		filterAndPrint(numbers, isOddPredicate); 
		
		
		List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x -> x + x);
		System.out.println(doubledNumbers);
	}
	
	//right click --> refactor and create new method 
	//here, we are passing isOddPredicate(which is a function/a behavior), as a PARAMETER 
	//thats why we call it behavioral parameter 
	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> isOddPredicate) {
		numbers.stream()
		.filter(isOddPredicate)
		.forEach(System.out :: println);
	}
	
	
	private static void squaredNumbers(List<Integer> numbers) {
		
		Function<Integer,Integer> mappingFunction = x -> x*x;
		mapAndCreateNewList(numbers, mappingFunction);
		
		
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
											Function<Integer, Integer> mappingFunction) {
		return numbers.stream()
				.map(mappingFunction)
				.collect(Collectors.toList());
	}
	
	
	
	

}
