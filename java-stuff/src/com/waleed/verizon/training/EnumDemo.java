package com.waleed.verizon.training;

enum PizzaSize{REGULAR(2), MEDIUM(4), LARGE(6), XLARGE(8);
	
	int serving;
	
	PizzaSize(int serving) {
		this.serving = serving;
	}
	
	public int getServing() {
		return this.serving;
	}
}

public class EnumDemo {
	
	int var;
	
	public static void main(String[] args) {
		new PizzaShop().displayMenu();
	}
}

class PizzaShop{
	void displayMenu() {
		System.out.println("Dear customer, we have the following sizes available currently:");
		
		PizzaSize[] sizes = PizzaSize.values();
		for(PizzaSize size : sizes) {
			System.out.println(size + " serves " + size.getServing() + " people...");
		}
		 
		 
	}
}





