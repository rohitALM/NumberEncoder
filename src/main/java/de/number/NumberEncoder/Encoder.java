/**
 * 
 */
package de.number.NumberEncoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Rohit
 * 
 */
public class Encoder {

	Encoder() {
		init();

	}

	private void init() {
		DictionaryReader reader = new DictionaryReader();
		reader.readFile();
		DigitWordMap digitWordMap = new DigitWordMap();
		encode();
	}

	private void encode() {
		File file = new File("input.txt");

		try {

			Scanner scan = new Scanner(file);

			while (scan.hasNextLine()) {
				String word = scan.next();
				computeOutputString(word);

			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void computeOutputString(String input) {
		input = input.replaceAll("\\D+", "");
		for (int i = 0; i < input.length(); i++) {
			System.out.println(input.charAt(i));
		}
	}

	private void recurseOutput(int num, char[] finalWordList) {
		
	}

}
