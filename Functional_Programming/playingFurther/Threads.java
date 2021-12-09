package playingFurther;

public class Threads {

	public static void main(String[] args) {

		/*Creating threads :
		 * 
		 * Traditional : 
		 * 1.Runnable Interface 
		 * 
		 * 
		 */
		Runnable runnable = new Runnable() {

			@Override
			public void run() {

				for(int i = 0 ; i< 10000 ; i++) {
					System.out.println(Thread.currentThread().getId() + ":" + i );
				}
				
				
			}
			
			
			
		}; 
		
		
		Thread thread = new Thread(runnable); 
		thread.start(); 
		
		Thread thread1 = new Thread(runnable); 
		thread.start(); 
		
		Thread thread2 = new Thread(runnable); 
		thread.start(); 
		
		Thread thread3 = new Thread(runnable); 
		thread.start(); 
		
	//==========================================================================
		//===========================Same thing in functional approach ============
		
		Runnable runnable2 = () -> {
			for(int i =0 ; i < 1000 ; i++) {
				System.out.println(Thread.currentThread().getId() + ":" );
			}
		};
		
	}

}

//=====================================================================
/*
 * how to use FB at its best in java apps : 
 * whenever u want to process a stream of elements 
 * 
 */
