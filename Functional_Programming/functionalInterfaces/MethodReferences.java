package functionalInterfaces;

import java.util.List;

public class MethodReferences {

	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API",
				"Microservises" , "AMG" , "PCP",
				"Azure", "Docker", "Kubernates"); 
		
		// u can call a method reference on a type of object (all obj of a specific type)
		courses.stream().map(str -> str.toUpperCase())// or String :: toUpperCase() --> method reference
		.forEach(str -> System.out.println(str)); // or system.out :: println which will be a method reference
		// u can use method reference also on a predefined static method , using class name :: method name
		
		// you can use a constructure reference like writing String :: new ; 
		// Supplier<String> supplier = () -> new String() ; 
	}

}
