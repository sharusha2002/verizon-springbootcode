package com.waleed.verizon.training;

public class AnnonymousVersion1Demo {
public static void main(String[] args) {
	
//	I have to call Footballer's play()
	Footballer footballer = new Footballer() {
		@Override 
		public void play() 
		{
			System.out.println("Magical this...");
			}
		};
//	1. Creating a annonymous class which happens to be a subclass of Footballer
//	2. Overrding play()
//	3. writing the logic in play()
//	4. closing the play()
//	5. Closing the annonymous class declaration
//	6. Creating a reference varaible of super type : Footballer
//	7. Creating an object of that annonymous class
//	8. Assigning the sub class object reference to super type ref variable
//	9. Closing the statement
	
	footballer.play();
	
}
}




@FunctionalInterface
interface Footballer{
	void play();
}





