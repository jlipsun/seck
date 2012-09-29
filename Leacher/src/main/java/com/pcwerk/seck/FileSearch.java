package com.pcwerk.seck;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileSearch {
	private static String REGEX = "[,.!\\s+<>/]";
	private Pattern pattern = Pattern.compile(REGEX);

	public int count(String needle, File haystack) {
		int count = 0;
		Scanner input;

		try {
			input = new Scanner(haystack);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

		while (input.hasNext()) {
			String line = input.nextLine();
			String[] words = pattern.split(line);
			for (String word : words) {
				if (word.equalsIgnoreCase(needle)) {
					count++;
				}
			}
		}
		return count;
	}
}
