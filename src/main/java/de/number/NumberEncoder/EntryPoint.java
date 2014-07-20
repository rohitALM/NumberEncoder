package de.number.NumberEncoder;

import java.util.List;

/**
 * Entrypoint ClassS
 * 
 */
public class EntryPoint {
	public static void main(String[] args) {

		DictionaryReader reader = new DictionaryReader();
		reader.readFile();
		DigitWordMap digitWordMap = new DigitWordMap();
		List<Character> list = digitWordMap.getDigitToWordMap().get(7);
		for (Character charrr : list) {
			System.out.println(charrr);
		}
	}
}
