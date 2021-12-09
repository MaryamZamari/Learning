package playingFurther;

import java.util.function.Predicate;


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




public class HigherOrderFunctions {

	
	/*
	 * Higher Order Functions are functions that return a Function 
	 */
	public static void main(String[] args) {

		int cutOffReviewScore = 95 ; 
		
		Predicate<Course> reviewCourseGT95Predicate = 
						createPredicatewithCutofReviewScore(cutOffReviewScore);
		
		Predicate<Course> reviewCourseGT90Predicate = 
				createPredicatewithCutofReviewScore(90);
		
		Predicate<Course> reviewCourseLT90Predicate = 
				createPredicatewithCutofReviewScoreLT(90);
		
		
		
		
		
		
		
	}
	/*
	 * we can store logic of method , in a Parameter 
	 * we are able to store methods as Local Variables 
	 * we are able to write Methods, like Methods 
	 */
	
	//basically , treating data, like data 
	//these are, higher order functions, as they return another function as a return value 
	private static Predicate<Course> createPredicatewithCutofReviewScore(int cutOffReviewScore) {
		return course -> course.getReviewScore() > cutOffReviewScore;
	}

	private static Predicate<Course> createPredicatewithCutofReviewScoreLT(int cutOffReviewScore) {
		return course -> course.getReviewScore() < cutOffReviewScore;
	}
} }
