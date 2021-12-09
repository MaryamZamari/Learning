package playingFurther;

import java.util.stream.LongStream;

public class Parallelizing {

	public static void main(String[] args) {

		
		//operation timing 
		long time1 = System.currentTimeMillis();
		
		//we want a huge number so i need a LongStream (0 , 1000000000)
		
		System.out.println(
				
				LongStream.range(0 , 1000000000).sum()
				
				);
		
		long time2 = System.currentTimeMillis();
	System.out.println(
				
				LongStream.range(0 , 1000000000).parallel().sum()
				
				);
		
		
		System.out.println("time1: " + (System.currentTimeMillis() - time1)); // --> 1935
		System.out.println("time2: " + (System.currentTimeMillis() - time2)); // --> 22 
	}
	//with structured code, it is not efficient to parallelize the code 

}
