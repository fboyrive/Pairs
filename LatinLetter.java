
public class LatinLetter extends Card {
	private static String possibleLetters = "abcdefghijklmnopqrstuvwxyz";

	LatinLetter () {
		int randomNumber = (int) (Math.random() * (possibleLetters.length()));
		char character = possibleLetters.charAt(randomNumber);
	    super.cardString = Character.toString(character);
		super.hidden = true;
		possibleLetters = possibleLetters.substring(0, randomNumber) + possibleLetters.substring(randomNumber+1);
	}
	
	LatinLetter (String cardString) {
		super.cardString = cardString;
		super.hidden = true;
	}
}
