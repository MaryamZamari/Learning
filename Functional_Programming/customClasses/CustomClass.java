package customClasses;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
	
	private String name ; 
	private String category ; 
	private int reviewScore; 
	private int nOfStudents;
	
	
	public Course(String name, String category, int reviewScore, int nOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.nOfStudents = nOfStudents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getnOfStudents() {
		return nOfStudents;
	}
	public void setnOfStudents(int nOfStudents) {
		this.nOfStudents = nOfStudents;
	}
	
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", nOfStudents="
				+ nOfStudents + "]";
	} 
	
	
	
	
}



public class CustomClass {

	public static void main(String[] args) {

		List<Course> courses = 
		List.of(
				
				new Course("Spring" , "Framework", 98 , 20000),
				new Course("Spring Boot" , "Framework", 95 , 18000),
				new Course("API" , "Microservices", 98 , 20000),
				new Course("Microservices" , "Microservices", 98 , 20000),
				new Course("Fullstack" , "Fullstack", 98 , 25000),
				new Course("AWS" , "cloud", 92 , 20000),
				new Course("Axure" , "cloud", 99 , 21000),
				new Course("Docker" , "cloud", 92 , 20000),
				new Course("Kubernetes" , "cloud", 91 , 20000)
				
				);
		
		//allMatch, noneMatch, anyMatch
		// for example if we want to find out which coursees have a review score more than a threshold 
		
		//allMatch --> is a Predicate (boolean)
		
		Predicate<Course> reviewCourseGT95Predicate = 
				course -> course.getReviewScore()> 95;
		
		Predicate<Course> reviewCourseGT90Predicate = 
				course -> course.getReviewScore()> 90;
		
		Predicate<Course> reviewCourseLT90Predicate = 
						course -> course.getReviewScore()< 90;
				
		System.out.println(
				
		//courses.stream().allMatch(course -> course.getReviewScore()> 95)
		courses.stream().allMatch(reviewCourseGT95Predicate)
		
		
				); 
		// allMatch --> if all elements return true to the condition
		//noneMatch --> returns true if none of the elements return true to this condition
		//anyMatch --> returns true if atleast one of the elements meets the condition
		System.out.println(courses.stream().anyMatch(reviewCourseGT95Predicate));
		
		System.out.println(courses.stream().noneMatch(reviewCourseLT90Predicate));
		
		System.out.println(courses.stream().anyMatch(reviewCourseLT90Predicate));
	
		//----------------------EXERCISE-----------------------------------------------
		
		//courses.stream().allMatch(course -> course.getnOfStudents() >20000);
		Predicate<? super Course> nStudentGT20000Predicate = course -> course.getnOfStudents() >20000;
		Predicate<? super Course> nStudentGT15000Predicate = course -> course.getnOfStudents() >15000;
		
		System.out.println(courses.stream().allMatch(nStudentGT20000Predicate));
		
		System.out.println(courses.stream().allMatch(nStudentGT15000Predicate));
		
		//==============================================================================
		
		//===========================>  SORTING <==================================
		
		//here we used reference method, to access a getter method of class 
		Comparator<Course> comparingByNStudents 
		= Comparator.comparing(Course :: getnOfStudents); 
		
		
		//increasing order
		System.out.println(courses.stream().sorted(comparingByNStudents).collect(Collectors.toList()));
		
		//decreasing order 
		System.out.println(courses.stream().sorted(comparingByNStudents.reversed()).collect(Collectors.toList()));
		
		//compare nOfStudentsVSnOfReviews
		Comparator<Course> comparingByNStudentsVSnReviews 
		
		/* Note : when you are working with PRIMITIVE data type, it is more efficient to use the 
		 comparator that is for that primitive type, instead of normal Comparator that performs
		  boxing/unboxing i.e ComparingInt etc.*/
		= Comparator.comparingInt(Course :: getnOfStudents)
			.thenComparing(Course :: getReviewScore)
			.reversed(); 
		
		
		//basically, using Comparator, we are personalising the CRITERIA based on which it SORTS the data.  
		
		System.out.println(courses.stream()
				.sorted(comparingByNStudentsVSnReviews)
				.collect(Collectors.toList()));
		
		
		//==============================================================================
		//================Skip_ Limit_ takeWhile - doWHile================================
		
		//imagine i dont want to return the full list, but want the first 5 --> LIMIT
		System.out.println(
				courses.stream()
				.sorted(comparingByNStudentsVSnReviews)
				.limit(5)
				.collect(Collectors.toList()));
		
		
		//now, for example i want to get the elements from 4 to 9 --- > skip(3).limit(5)
		
		System.out.println(
				
				courses.stream()
				.sorted(comparingByNStudentsVSnReviews)
				.skip(3)
				.limit(5)
				.collect(Collectors.toList())
				
				);
		
		//now i want to go through all the elements, till the element that includes a specific element --> takeWhile()
		System.out.println("\n\n takeWhile: \n");
		System.out.println(
				
				courses.stream().
				takeWhile(course -> course.getReviewScore()>= 95)
				.collect(Collectors.toList())
				
				);
		
		//dropWhile --> it still looks for that condition, till it arrives at the element that meets the condition and drops them then continues returning the rest
		
		System.out.println("\n\n dropWhile: \n");
		System.out.println(
				
				courses.stream().
				dropWhile(course -> course.getReviewScore()>= 95)
				.collect(Collectors.toList())
				
				//[Course [name=AWS, category=cloud, reviewScore=92, nOfStudents=20000], 
				//Course [name=Axure, category=cloud, reviewScore=99, nOfStudents=21000],
				//Course [name=Docker, category=cloud, reviewScore=92, nOfStudents=20000],
				//Course [name=Kubernetes, category=cloud, reviewScore=91, nOfStudents=20000]]		
				);
		
		//==============================================================================================
		//==================================TOP, MAX , MIN =============================================
		System.out.println("\n \n Max , Min :  \n ");
		
		System.out.println(
				courses.stream().max(comparingByNStudentsVSnReviews)
				);
		
		System.out.println(
				courses.stream()
				.min(comparingByNStudentsVSnReviews)
				.orElse(new Course("Kubernetes", "Cloud" , 91, 20000)) // orElse, is to handle the situation where it does not find a result, so doesnt go to Null/optional , and returns this
				);
		
		/*
		 * Max : Optional[Course [name=Spring Boot, category=Framework, reviewScore=95, nOfStudents=18000]]
		   Min : Optional[Course [name=Fullstack, category=Fullstack, reviewScore=98, nOfStudents=25000]]
					Optional is a way to avoid getting Null and going to exception 
		 */
		
		
		//findFirst returns the first element that meets the given criteria
		System.out.println(
				
				courses.stream()
				.filter(reviewCourseLT90Predicate)
				.findFirst()
				
				);
		
		//findAny returns one of the elements that meets the given criteria
		System.out.println(
				
				courses.stream()
				.filter(reviewCourseLT90Predicate)
				.findAny()
				
				);
		
		//==============================================================================================
		//==================================Sum , Average , Count =============================================
		System.out.println("\n sum: \n");
		System.out.println(
				
				courses.stream()
				.filter(reviewCourseGT95Predicate)
				.mapToInt(course -> course.getnOfStudents()) //cos the return type is primitive
				//.map(course :: getnOfStudents()
				.sum()); //106000
				
		System.out.println("\n Averages:\n");		
		System.out.println(
				
				courses.stream()
				.filter(reviewCourseGT95Predicate)
				.mapToInt(course -> course.getnOfStudents()) //cos the return type is primitive
				//.map(course :: getnOfStudents()
				.average());	//OptionalDouble[21200.0]
		
		
		
		//grouping courses based on some criteria 
		System.out.println(
				
				courses.stream()
				.collect(Collectors.groupingBy(Course :: getCategory))
				
				);
		
		
		//Counting something based on criteria 
		System.out.println(
				
				courses.stream()
				.collect(Collectors.groupingBy(Course :: getCategory, Collectors.counting()))
				
				);
		
		//comparing the course with maximum reviewScore within a specific category 
		courses.stream()
		.collect(Collectors.groupingBy(Course :: getCategory, 
										Collectors.maxBy(Comparator.comparing(Course :: getReviewScore))));
		
		
		//we want to map the name of the course 
		System.out.println("\n \n mapping \n");
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course :: getCategory,
				Collectors.mapping(Course :: getName, Collectors.toList())))
		/*
		 * {cloud=[AWS, Axure, Docker, Kubernetes], Fullstack=[Fullstack],
		 *  Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}		
		 *				*/
				);
		
		
	}

}
