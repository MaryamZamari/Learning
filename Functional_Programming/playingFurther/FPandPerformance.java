package playingFurther;

import java.util.List;

public class FPandPerformance {

	/*
	 * FP existed since 50 years ago, but why is it suddenly important? 
	 * Performance --> functional programming helps you write Performant code 
	 * multicode processes, PARALLELIZING functional code is easier than structured programming 
	 */
	
	public static void main(String[] args) {
		
		List<String> courses = List.of("Spring" , "Spring Boot" , "API" ,
				"Microservices" , "AWS" , "PCF" , "Azure" , "Docker" , "Kubernetes");
		
	//with FP , intermediate operations get easy and they do not get executed until we arrive at the last function. 
				System.out.println(
						
						courses.stream()
						.peek(System.out :: println)
						.filter(course -> course.length() > 11)
						.map(String :: toUpperCase).peek(System.out :: println).findFirst()
						//returns Optional[MICROSERVICES]
						);
				
				
System.out.println(
					//the intermediate operations will not get executed becoz it does not find out what you want (as we dont have a terminal operation)	
						courses.stream()
						.peek(System.out :: println)
						.filter(course -> course.length() > 11)
						.map(String :: toUpperCase).peek(System.out :: println)
						//returns Optional[MICROSERVICES]
						);
				
			
				
		
		
		
		
		
		
		
	}

}
