package com.goldilocks;

import java.util.Scanner;

public class InputAndOutput {

	public static void main(String[] args) {
		Scanner sr=new Scanner(System.in);
		
	
		System.out.println("If You Wants to exists this problem please write exists");
		
		System.out.print("Enter your skills : ");
		String input = sr.nextLine();
		do{
			System.out.println(input);
			input = sr.nextLine();
		}while(!(input.toUpperCase().equals("EXISTS")));
		
		System.out.println("Program is close successfully");
	}
	
}
