/**
 * 
 */
package de.number.NumberEncoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohit
 * 
 */
public class DigitWordMap {

	private Map<Integer, List<Character>> digitToWordMap = new HashMap<Integer, List<Character>>(10);

	DigitWordMap() {
		buildMap();
	}

	private void buildMap() {

		List<Character> charList0 = Arrays.asList('e', 'E');
		List<Character> charList1 = Arrays.asList('j', 'n', 'q', 'J', 'N', 'Q');
		List<Character> charList2 = Arrays.asList('r', 'w', 'x', 'R', 'W', 'X');
		List<Character> charList3 = Arrays.asList('d', 's', 'y', 'D', 'S', 'Y');
		List<Character> charList4 = Arrays.asList('f', 't', 'F', 'T');
		List<Character> charList5 = Arrays.asList('a', 'm', 'A', 'M');
		List<Character> charList6 = Arrays.asList('c', 'i', 'v', 'C', 'I', 'V');
		List<Character> charList7 = Arrays.asList('b', 'k', 'u', 'B', 'K', 'U');
		List<Character> charList8 = Arrays.asList('l', 'o', 'p', 'L', 'O', 'P');
		List<Character> charList9 = Arrays.asList('g', 'h', 'z', 'G', 'H', 'Z');
		digitToWordMap.put(0, charList0);
		digitToWordMap.put(1, charList1);
		digitToWordMap.put(2, charList2);
		digitToWordMap.put(3, charList3);
		digitToWordMap.put(4, charList4);
		digitToWordMap.put(5, charList5);
		digitToWordMap.put(6, charList6);
		digitToWordMap.put(7, charList7);
		digitToWordMap.put(8, charList8);
		digitToWordMap.put(9, charList9);

	}

	public Map<Integer, List<Character>> getDigitToWordMap() {
		return digitToWordMap;
	}
}
