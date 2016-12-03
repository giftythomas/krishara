package com.fsfbackend.util;

public class Util {

	public String replace(String s, String char1, String char2){
		return s.replace(char1, char2);
	}
	
	public static void main(String[] args) {
		Util u=new Util();
		String newString=u.replace(", PRD", ",", "");
		System.out.println(newString);
	}
}
