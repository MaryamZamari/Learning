package playingFurther;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayingFurther {

	public static void main(String[] args) {

		//Joining Strings with Joining and Playing with flapMap
		List<String> courses = List.of("Spring" , "Spring Boot" , "API" ,
				"Microservices" , "AWS" , "PCF" , "Azure" , "Docker" , "Kubernetes");
		
		System.out.println(courses.stream().collect(Collectors.joining(",")));
	
		//================================================================================
		//================================  FLATMAP  =====================================
		
		/*
		 * A flatmap helps us flattening a Stream of String Arrays --> Stream of Strings 
		 */
		
		//creates a string array with individual characters 
		System.out.println("Spring".split(""));
		
		System.out.println(
				/*
				 * the solution below will not work out becoz it will go into error
				 * we have to have to flatten the stream using FlatMap
				 */
				//courses.stream().map(course -> course.split("").collect(Collectors.toList()))
				
				

				courses.stream()
				.map(course -> course.split(""))
				.flatMap(Arrays :: stream)
				.collect(Collectors.toList())
				
				); 
				
		
			//we want to match elements with other elements ----> tuples
				List<String> courses2 = List.of("Spring" , "Spring Boot" , "API" ,
						"Microservices" , "AWS" , "PCF" , "Azure" , "Docker" , "Kubernetes");
				
				//each element of this stream , is a list of two elements 
				System.out.println(
						courses.stream()
						.flatMap(course -> courses2.stream()
						.map(course2 -> List.of(course , course2)))
						.collect(Collectors.toList())
						);
				
				//each element of this stream , is a list of two elements
				//we want to filter the elements which have the same lengths/ similar content
				System.out.println(
						courses.stream()
						.flatMap(course -> courses2.stream()
						.map(course2 -> List.of(course , course2)))
						.filter(list -> !list.get(0).equals(list.get(1)))
						.collect(Collectors.toList())
						);
				
				
				//then, we want to also filter, based on the length of course names in course1 and course2
				System.out.println(
						courses.stream()
						.flatMap(course -> courses2.stream()
						.filter(course2 -> course2.length() == course.length())
						.map(course2 -> List.of(course , course2)))
						.filter(list -> !list.get(0).equals(list.get(1)))
						.collect(Collectors.toList())
						);
		
		
		
		
		
		
	}

}
