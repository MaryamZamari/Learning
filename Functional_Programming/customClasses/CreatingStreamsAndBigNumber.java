package customClasses;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
 * so far, for creating streams, we did someting like that numbers.stream()
 * but, there is a way to create streams directly : 
 * 
 * Stream.of(12 ,9 , 13 , 4 , 6 , 2 , 4 , 12 , 15)
 */



public class CreatingStreamsAndBigNumber {

	public static void main(String[] args) {
		//it will contain, Integer wrapper class so it is not efficient 
		System.out.println(
				Stream.of(12 ,9 , 13 , 4 , 6 , 2 , 4 , 12 , 15).count()
				);
		
		
		System.out.println(
				Stream.of(12 ,9 , 13 , 4 , 6 , 2 , 4 , 12 , 15)
				.reduce(0, Integer :: sum)
				
				);
		
		//streams of primitive values --> array
		int[] numberArray ={12 ,9 , 13 , 4 , 6 , 2 , 4 , 12 , 15};
		Arrays.stream(numberArray);
		
		Arrays.stream(numberArray).min() ; 
		Arrays.stream(numberArray).sum();
		
		//===========================================================================
		//============================  Creating  Streams of Primitive Values, Dynamically ==============================
		//sums up the numbers 1 to 9 
		
		System.out.println(IntStream.range(1, 10).sum());
		
		//to generate a stream of primitive int , using an algorithm 
		System.out.println(" \n generating intStream of 10 elements, using an algorithm: \n ");
		IntStream.iterate(1,  e -> e + 2 ).limit(10)
		.peek(System.out :: println).sum();
		
		
		//exercise : print all the even numbers, using a peak 
		// in order to do that, you can not use a predicate (boolean) so u have to do another way
		IntStream.iterate(2 , e -> e + 2).limit(10).peek(System.out :: println).sum();
		
		IntStream.iterate(2,  e -> e * 2).limit(10).peek(System.out :: println).sum();
		
		//you can not apply a Collector on a PRIMITIVE stream --> you need to box it first 
		System.out.println(
				
				IntStream.iterate(2,  e -> e *2 )
				.limit(10).boxed()
				.collect(Collectors.toList())		
				
				);
		 
		System.out.println(
				"\n \n" +
				//here with IntStream, id get wrong values, because i reach the Maximum value for an int, 
				//in this case i need to use LongStream instead, and also use mapToObj() to get a BigInteger 
				// we use big integer when the result is a super big number 
				
				LongStream.rangeClosed(1 , 50).mapToObj(BigInteger :: valueOf)
				.reduce(BigInteger.ONE , BigInteger :: multiply));
				
				
		
	}

}
