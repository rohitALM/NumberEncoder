/**
 * 
 */
package de.number.NumberEncoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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
		List<String> finalOutput = new ArrayList<String>();
		List<String> possiblePrefixes = new ArrayList<String>();
		String currentWord = "";
		constructOutput(input, possiblePrefixes, currentWord, finalOutput);

	}

	private void constructOutput(String input, List<String> possiblePrefixes, String currentWord,
			List<String> finalOutput) {

	}

	/**
	 * 
	 * 
	 * @param possiblePrefixes
	 * @param currentPrefixList
	 * @return
	 */
	private List<String> multiplyPrefixes(List<String> possiblePrefixes, List<String> currentPrefixList) {
		if (0 == possiblePrefixes.size())
			return currentPrefixList;

		List<String> multipliedList = new ArrayList<String>();
		for (int i = 0; i < possiblePrefixes.size(); i++) {
			for (int j = 0; j < currentPrefixList.size(); j++) {
				multipliedList.add(possiblePrefixes.get(i).concat(currentPrefixList.get(j)));
			}
		}
		return multipliedList;

	}

}
