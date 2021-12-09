package playingFurther;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Text {

	public static void main(String[] args) throws IOException {
		//we want to read the content of that file 
		//do this for each line 
		Files.lines(Paths.get("file.txt"))
		.forEach(System.out :: println) ; 
		
		//we want to find the unique words that are in the file 
		//it gives you letter by letter 
				Files.lines(Paths.get("file.txt"))
						.map(str -> str.split(" "))
						.flatMap(Arrays :: stream)
						.distinct()
						.sorted()
						.forEach(System.out :: println);
		
		
		
		//it gives you letter by letter 
		Files.lines(Paths.get("file.txt"))
				.map(str -> str.split(""))
				.flatMap(Arrays :: stream)
				.forEach(System.out :: println); 
		
		//goes to the root folder and brings me all the file there
		Files.list(Paths.get("."))
		.forEach(System.out :: println);
		
		System.out.println("\n\n isDirectory : \n");
		//if i want to see only directories
		Files.list(Paths.get("."))
		.filter(Files :: isDirectory)
		.forEach(System.out :: println);
					
		
		
		
		
		
		
		
		
	}

}
