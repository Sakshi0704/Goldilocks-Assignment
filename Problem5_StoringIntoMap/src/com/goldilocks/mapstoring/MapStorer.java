package com.goldilocks.mapstoring;

import java.util.*;
import java.util.Map.Entry;

public class MapStorer {
	
	public static Map<String,Integer> students=new LinkedHashMap<>();
	
	public static boolean isNumberic(String word) {
		try {
			Integer.parseInt(word);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static void manu() {
		System.out.println("Select your choice from below");
		System.out.println("0. To Exit from Application");
		System.out.println("1. To Add New Student To The Map Record");
		System.out.println("2. To Get Age Of A Perticuler Student Using Student Name");
		System.out.println("3. To Show All Map Record");
	}
	
	public static void main(String args[]) {
		
		Scanner sr = new Scanner(System.in);
		String choice = "0";
		
		do {
			manu();
			System.out.print("Enter your choice ");
			choice = sr.next();
			switch(choice) {
				case "1": 
					System.out.print("Enter The Student Name");
					String name=sr.nextLine();
					System.out.print("Enter the the age of the Student should be between 12-40");
					String age=sr.next();
					sr.nextLine();
					while(!isNumberic(age)||Integer.parseInt(age)>50||Integer.parseInt(age)<10) {
						System.out.println("Please Provide valid age , "
								+ "age should between 10 to 50 only and "
								+ "check the format as well");
						age=sr.next();
						sr.nextLine();
					}
					students.put(name,Integer.parseInt(age));
						break;
						
				case "2" :
					if(students.isEmpty()) {
						System.out.println("No Record of Student data");
					}else {
						int index=1;
						System.out.println("Index"+"\t\t"+"Name"+"\t\t"+"Age");
						for(Entry<String, Integer> map : students.entrySet()) {
							System.out.println(index+"\t\t"+map.getKey()+"\t\t"+map.getValue());
							index++;
						}
					 }
				   break;
				   
				case "3" :
					System.out.print("Enter the name of the student to get the age : ");
					String studentName = sr.nextLine();
					if(students.containsKey(studentName)) {
						System.out.println("Student name is "+studentName
								+" and his/her age is "+students.get(studentName));
					}else {
						System.out.println("Student not found");
					}
					
					break;
					
				case "0" :
					   System.out.println("Thank you for visiting");
						break;
						
				default: System.out.println("Please enter the vaild choice");
						break;
					
			}
		}while(!choice.equals("0"));
	}
	
}
