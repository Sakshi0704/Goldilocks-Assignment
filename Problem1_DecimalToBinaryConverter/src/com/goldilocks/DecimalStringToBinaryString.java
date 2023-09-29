package com.goldilocks;
import java.util.Scanner;


public class DecimalStringToBinaryString {
	
	public static void main(String args[]) {
		Scanner sr = new Scanner(System.in);
	  
		int choice = 0;
		do {
			System.out.print("Enter a number to convert it into Binary number : ");
			String decimalString = sr.next();
			if(checkForInteger(decimalString)) {
				int decimalNumber = Integer.parseInt(decimalString);
				
				StringBuilder binaryString = new StringBuilder();
				
				convertIntoBinary(decimalNumber,binaryString);
				
				System.out.println(binaryString);
				choice = 1;
			}
			else {
				System.out.println("Please provide me the correct input");
			}
			
		}while(choice!=1);
		
	}
	// 25/2==12/2
	// 24/2 == 12/2==6/2==3/2==1
	// 00011
	//111 ==> 2^2+2^1+2^0
	//4+2+1==> 7
	
	public static boolean checkForInteger(String str) {
	
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException ex) {
			//System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public static void convertIntoBinary(int decimalNumber, StringBuilder binaryString) {
		  if(decimalNumber==0 || decimalNumber == 1) {
			  binaryString.append(decimalNumber);
			  return;
		  }
		  convertIntoBinary(decimalNumber/2,binaryString);
		  binaryString.append(decimalNumber%2);	  
	}
	
}
