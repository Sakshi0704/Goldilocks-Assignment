package com.goldilocks;
import java.util.Scanner;


public class DecimalStringToBinaryString {
	
	public static void main(String args[]) {
		Scanner sr = new Scanner(System.in);
		System.out.print("Enter a number to convert it into Binary number : ");
		String decimalString = sr.next();
	
		try {
		
			int decimalNumber = Integer.parseInt(decimalString);
			
			StringBuilder binaryString = new StringBuilder();
			
			convertIntoBinary(decimalNumber,binaryString);
			
			System.out.println(binaryString);
			
		}catch(NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
	}
	// 25/2==12/2
	// 24/2 == 12/2==6/2==3/2==1
	// 00011
	public static void convertIntoBinary(int decimalNumber, StringBuilder binaryString) {
		  if(decimalNumber==0 || decimalNumber == 1) {
			  binaryString.append(decimalNumber);
			  return;
		  }
		  convertIntoBinary(decimalNumber/2,binaryString);
		  binaryString.append(decimalNumber%2);	  
	}
	
}
