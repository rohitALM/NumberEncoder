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

	private DictionaryReader reader;

	Encoder() {
		init();

	}

	private void init() {
		reader = new DictionaryReader();
		reader.readFile();
		DigitWordMap.buildMap();
		encode();
	}

	public void encode() {
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

		// Exit from recursion if end of input is reached storing current word
		// in final output string
		if (0 == input.length()) {
			finalOutput.add(currentWord);
			return;
		}
		int num = Character.digit(input.charAt(0), 10);

		List<String> currentPrefixList = DigitWordMap.getDigitToWordMap().get(num);
		List<String> newPossibilities = multiplyPrefixes(currentPrefixList, currentPrefixList);
		validatePrefixes(newPossibilities);
		if(0 == newPossibilities.size()) {
			addDigitAsIs();
		}

	}
	
	
	private void addDigitAsIs() {
		
	}

	/**
	 * Validate prefixes by checking against entries in dictionary Removes
	 * prefixes which are not present
	 * 
	 * @param prefixes
	 */
	private void validatePrefixes(List<String> prefixes) {
		for (int i = 0; i < prefixes.size(); i++) {
			if (!reader.getDictTrie().containsPrefix(prefixes.get(i))) {
				prefixes.remove(i);
			}
		}
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
