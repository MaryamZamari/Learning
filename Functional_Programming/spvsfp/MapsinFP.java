package spvsfp;

import java.util.List;

public class MapsinFP {

	
	
	public static void printSquaresFunctional1(List<Integer>numbers) {
		numbers.stream()
		//lambda : parameter -> condition 
		//.filter(number -> number %2 != 0)
		.map(number -> number * number)
		.forEach(System.out:: println); 
	}
	
	
	
	
	
	
	public static void main(String[] args) {

		printSquaresFunctional1(List.of(1,3,11,18,19));
		
		
		
	}

}
