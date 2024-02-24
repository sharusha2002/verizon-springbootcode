package com.waleed.verizon.training;

public class RegularInnerDemo {
public static void main(String[] args) {
	
//	new Outer().out();
	
	new Outer().new Inner().met();
}
}


class Outer{
	private int value;
    class Inner{
        int value;
        void met(){
        	int value = 10;
           System.out.println("Inside Inner's in...");
           System.out.println("Local value : " + value);
           System.out.println("Instance value : " + this.value);
           System.out.println("Outer's Instance value : " + Outer.this.value);
        }
    }
    
    void func() {
    	Inner ref = new Inner();
    	ref.met();
    }
    
    
    
}
