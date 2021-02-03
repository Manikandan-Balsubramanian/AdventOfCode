package com.advent.days;

import com.util.Utils;
import java.io.File;
import java.util.List;
import java.util.Arrays;

public class Day2 {

	public static void main(String[] args) {
		String path = "AdventOfCode/2020/data/day2.txt";
		List<String> passPolicyList = Utils.convertFileToStringList(new File(path));
		System.out.println("count: " + validPassCount(passPolicyList, false));
		System.out.println("count: " + validPassCount(passPolicyList, true));
	}

	public static int validPassCount(List<String> passPolicyList, boolean isNew) {
		int counter = 0;
		for(String passPolicy : passPolicyList) {
			String[] arr = passPolicy.split("[-|\\s+|:]+");
			int minCount = Integer.parseInt(arr[0]);
			int maxCount = Integer.parseInt(arr[1]);
			String character = arr[2];
			String password = arr[3];

			if(isNew) {
				if(isNewValid(minCount, maxCount, character, password)){
					counter++;
				}	
			} else {
				if(isValid(minCount, maxCount, character, password)){
					counter++;
				}	
			}
		}
		return counter;
	}

	public static boolean isValid(int minCount, int maxCount, String character, String password) {
		int count = 0; 

		for(String pass: password.split("")) {
			if(pass.equals(character)) {
				count++;
			}
		}
		return (count >= minCount && count <= maxCount);
	}

	public static boolean isNewValid(int minCount, int maxCount, String character, String password) {
		boolean bool = false;

		if(password.charAt(minCount - 1) ==  character.charAt(0)) {
			bool = !bool;
		}

		if(password.charAt(maxCount - 1) ==  character.charAt(0)) {
			bool = !bool;
		}
		

	return bool;
	}


}