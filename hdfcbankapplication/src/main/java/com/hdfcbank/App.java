package com.hdfcbank;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		UserSign usersign = context.getBean("userSign", UserSign.class);
		TransactionOperations transactionOperations=context.getBean("transactionOperations",TransactionOperations.class);
		Scanner sc = new Scanner(System.in);
		Integer choiceOfSigning;
		String runOrStop;
		do {
			System.out.println("Enter 1 to signup");
			System.out.println("Enter 2 to signin");
			System.out.println("Enter 3 to signout");
			System.out.println("Please enter your option from 1-3");
			choiceOfSigning = sc.nextInt();
			switch (choiceOfSigning) {
			case 1:
				System.out.println("sign up");
				System.out.println("Please enter the user details");
				System.out.println("Please enter name email password");
				String signUpName = sc.next();
				String signUpEmail = sc.next();
				String signUpPassword = sc.next();
				if (usersign.signUp(new UserDetails(signUpName, signUpEmail, signUpPassword)) == 1)
					System.out.println("User added successfully");
				else
					System.out.println("User already Registered");
				break;
				
			case 2:
				System.out.println("You are signing-in");
				System.out.println("Enter email and password to sign-in");
				String signInEmail=sc.next();
				String signInPasssword=sc.next();
				if(usersign.signIn(signInEmail, signInPasssword)) {
					System.out.println("Logged in successfull at : "+new java.util.Date().toLocaleString());
					transactionOperations.multipleOperationOptionsAfterSigninin(signInEmail);
				}
				else {
					System.out.println("Please enter Validsign in credentails");
				}
				break;
			case 3:
				System.out.println("You are going to signout from the application");
				break;
				default:
					System.out.println("Enter a valid option");

			}

			System.out.println("enter true");
		} while (sc.nextBoolean() == true);
	}
}
