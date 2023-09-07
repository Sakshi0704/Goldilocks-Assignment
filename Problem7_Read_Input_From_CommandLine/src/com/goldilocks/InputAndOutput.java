package com.goldilocks;

import java.util.Scanner;

public class InputAndOutput {

	public static void main(String[] args) {
		Scanner sr=new Scanner(System.in);
		
	
		System.out.println("To close this progam write exit");
		String input;
		do{
			System.out.print("Enter your skills : "); input = sr.nextLine();
		}while(!(input.toUpperCase().equals("EXIT")));
		
		System.out.println("Program is close successfully");
	}
	
}
