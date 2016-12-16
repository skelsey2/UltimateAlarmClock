package com.steveace6.helper;

public class StringManipulation {

	
	public static String addSlashesNextToSlashes(String string){
		StringBuilder bString = new StringBuilder(string);
		for(int i = 0; i < bString.length(); i++){
			if(bString.charAt(i) == ('\\')){
				System.out.println("found a \\");
				bString.insert(i,'\\');
				i++;
			}
			
		}
		System.out.println(bString);
		return bString.toString();
	}
	
}
