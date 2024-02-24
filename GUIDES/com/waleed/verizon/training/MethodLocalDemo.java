package com.waleed.verizon.training;

public class MethodLocalDemo {
	public static void main(String[] args) {
		new Other().func();
		
//		 float val = 78.90f; //Effectively final after java 8
			
	}
}


class Other{
	void func() {
		boolean flag = false;
		class Inner{
			void met() {
				System.out.println("Inside Inner's met...");
				System.out.println(flag);
			}
		}
		new Inner().met();
	}
}
