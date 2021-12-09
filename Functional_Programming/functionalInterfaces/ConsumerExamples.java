package functionalInterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExamples {

	public static void main(String[] args) {
		
		//ONE PARAMETER as INPUT , PROCESS , no need to give back sth
		//consumer needs 1 parameter 
		
		// the code below can not be compiled
		//Consumer<String> consumer= (String a) -> {System.out :: println};
		
		
		Consumer<String> consumer1 = (str) -> System.out.println(str); 
		
		
		BiConsumer<String , String> biConsumer = (str, str2) -> System.out.println(str); 
		
		// no parameters ---------> i got problems with supplier. why?
		//does not accept target type <string etc>
		Supplier<String> supplier = () ->{ return "ranga"; } 
		
		
		
		
		
		
		
		
	}

}
