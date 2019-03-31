package com.sprhiber.util;

import java.util.Arrays;

public class ValidForm {
	static {
		System.out.println("Validating Class");
	}

	final int MAX_VALUE = 256;

	public String checkValid(String str) {
		String YES = "VALID";
		String NO = "INVALID";

		if (str.isEmpty()) {
			return NO;
		}
		if (str.length() <= 3) {
			return YES;
		}
		int[] a = new int[MAX_VALUE];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			a[(char) c]++;
		}
		int i = 0;
		Arrays.sort(a);
		while (a[i] == 0) {
			i++;
		}
		int min=a[i];
		int max=a[255];
		String out=NO;
		if(min==max) {
			out=YES;
		}else if(((max-min==1)&&(max>a[254]))||(min==1&& a[i+1]==max)){
			out=YES;
		}
		return out;
	}

}
