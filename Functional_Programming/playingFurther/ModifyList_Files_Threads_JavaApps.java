package playingFurther;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyList_Files_Threads_JavaApps {

	public static void main(String[] args) {

		//modification 
		//List.of returns an Unmodifiable List so we can not use it for here 
		List<String> courses = List.of("Spring" , "Spring Boot" , "API" ,
				"Microservices" , "AWS" , "PCF" , "Azure" , "Docker" , "Kubernetes");
		//replaceAll --> uses a Function as parameter 
		List<String> modifiableCourses = new ArrayList<>(courses); 


		
				//chera nemishe print begiram? 
		modifiableCourses.replaceAll(str -> str.toUpperCase());
		
		//nashod az list print begiram
		System.out.println(
				modifiableCourses.removeIf(course -> course.length() < 6)
				
				);
		 
				
				
		
				
				
				
		
		
		
	}

}
