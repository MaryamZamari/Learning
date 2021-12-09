package functionalInterfaces;
//java.util.function package 
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

/*
 * Functional Interfaces we looked so far : 
 * 
 * Predicate ==> Represents a Boolean Condition 
 * 
 * Function ==> takes an INPUT , returns Output
 * 
 * Consumer ==> you get ONE INPUT, and you need to Process it, but not necessarily giving something back
 * 
 * BinaryOperator ==> when you need to ADD something(like some of numbers) --> you get Two Inputs, and you get back One Output
 * 
 * Supplier ==> the situation where you dont have INPUT , but you RETURN something back
 *				like when you want to create a new obj of something  
 * 
 * 
 */




public class Supplier {
/*
 * Supplier ==> the situation where you dont have INPUT , but you RETURN something back
 *				like when you want to create a new obj of something
 *				you can not pass a parameter to Supplier 
 */
	
	

	
	
	public static void main(String[] args) {

		//no INPUT , Return something 
		Supplier<Integer> randomIntegerSupplier = () -> {
			//a random number
			Random random = new Random(); 
			return random.nextInt(1000); 
		};
		
		System.out.println(randomIntegerSupplier.get());
		
		
		//UnaryOperator ---> gets one Input and returns 1 Output of SAME TYPE
		UnaryOperator<Integer> unaryOperator = (x) -> x * 3; 
		System.out.println(unaryOperator.apply(10));
		
		
		
		
		//BiPredicate ---> an Interface similar to PREDICATE 
		// in Predicate the input is 1, and output is boolean
		//in BiPredicate, you have 2 Inputs, and Output is Boolean
		
		BiPredicate<Integer, String> biPredicate = (number, str) -> {
		
			return number < 10 && str.length() > 5 ; 
		}; 
		System.out.println(biPredicate.test(15, "in28minutes"));
		
		
		//BiFunction can take Two Inputs, and return an output (any type)
		BiFunction<Integer, String> biFunction = (number, str) -> {
			
			return number< 10 && str.length() > 5 ; 
		}; 
		
		
		
		BiFunction<Integer, String, String> biFunction1 = (number, str)->{
			return  number + "" + str ; 
		}; 
		
		
		
		BiConsumer<String, String> biConsumer = (s1, s2) -> {
			System.out.println(s1); 
			System.out.println(s2); 
			System.out.println(s3); 
		};
		
		biConsumer.accept(15, "in28minutes");
		
		
		/*
		 * this way u dont have to use wrapper classes<Integer> for lambda expressions
		 * 
		 * IntBinaryOperator
		 * IntConsumer
		 * IntFunction
		 * IntPredicate
		 * IntSupplier
		 * IntToDoubleFunction
		 * etc.
		 * 
		 */
		IntBinaryOperator intBinaryOperator = (x, y) -> x + y ; 
		
		
		
		
	}

}
