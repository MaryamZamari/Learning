package spvsfp;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.net.httpserver.Filter;

public class CoursesIndividually {
//map, filter, distinct and sorted, are all intermediate operations 
	//collectore is the opposie of stream, so converts a stream to a list 
	// 1.convert to stream 2.intermediate operations on the stream, 3. collect the stream to list
	//structural
	public static void printCoursesStructural(List<String> courses) {
		for(String course : courses) {
			System.out.println(course);
		}
		
		
	}
	
	//functional---> lambda and reference methods
	public static void printCoursesFunctional(List<String> courses) {
	
		courses.stream()
		.forEach(System.out :: println);
		}
	
	// ONLY SPRING
	public static boolean isSpring(String courses) {
		return courses.toLowerCase().startsWith("spring");
	}
	
	//functional
	public static void onlySpringFunctional(List<String> courses) {
		
		courses.stream()
		.filter(CoursesIndividually :: isSpring) //intermediate operations
		.forEach(System.out :: println);
		
	}
	
	public static void atleastFourLettersFunctional(List<String>courses) {
		
		courses.stream()
		.filter(course -> course.length()>= 4)
		.map(course -> course.length()) //returns for each course, the length of string
		.forEach(System.out :: println) ; 
	}
	//we use filter to filter out/in the results based on a condition
	//we use method references to call out the static methods (methods of class)
	
	//for sorting strings in alphabetical order, we use sorted(comparator.naturalOrder())
	public static void sortingStrings(List<String> courses) {
		
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out :: println);
	}
	
	//here we defined a comparison criteria for strings to be compared based on length
public static void sortingStringsPersonalised(List<String> courses) {
		
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out :: println);
	}
	
	public static void main(String[] args) {

		
		List<String> courses = List.of("Spring", "Spring Boot", "API",
										"Microservises" , "AMG" , "PCP",
										"Azure", "Docker", "Kubernates"); 
		
		printCoursesStructural(courses);
		
		printCoursesFunctional(courses);
		
		onlySpringFunctional(courses);
		
		atleastFourLettersFunctional(courses); 
		
		List<Integer> courseLength = courses.stream().map(x -> x.length()).collect(Collectors.toList());
		System.out.println(courseLength);
	}

}
