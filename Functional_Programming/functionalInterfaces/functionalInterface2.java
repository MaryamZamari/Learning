package functionalInterfaces;

import java.util.List;
import java.util.function.BinaryOperator;

public class functionalInterface2 {

	public static void sums(List <Integer> numbers) {
		
		BinaryOperator<Integer> sumBinaryOperator = Integer :: sum;
		int sum= numbers.stream()
				.reduce(0, sumBinaryOperator);
		
	}
	
	//all kinds of operations that take in 2 numbers and compare 
	//an anonymous class
	BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {

		@Override
		public Integer apply(Integer a,  Integer b) {

			return a + b;
		}
		
	}; 
	
	
	
	//----------------------------------------------------------------------------
	public static void main(String[] args) {

		List<Integer>numbers= List.of(12,9, 13,4, 6,2, 4, 12, 15);
		
		
		
		
		
		
		
	}

}
