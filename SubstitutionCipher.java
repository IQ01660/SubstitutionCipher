import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SubstitutionCipher extends Cipher{
	private char[] originalLetters = new char[256];
	public char[] secretLetters = new char[256];
	
	public SubstitutionCipher(long key) {
		super(key);
		Random rand = new Random(key);
		
		//filling values into originalLetters
		for (int i = 0; i < 256; i++){
			originalLetters[i] = (char) i;
			//copying the letters into secret table
			secretLetters[i] = (char) i;
		}
		
		//shuffling the letters and putting them into a new array
		for (int i = secretLetters.length - 1; i > 0; i--) {
			//swapping the letter with a random letter
			char temp = secretLetters[i];
			int randomIndex = rand.nextInt(256);
			secretLetters[i] = secretLetters[randomIndex];
			secretLetters[randomIndex] = temp;
		}
	}
	@Override
	public List<Character> encrypt (List<Character> cleartext){
		//the text of cipher
		List<Character> ciphertext = new LinkedList<Character>();
		
		for(char clearLetter : cleartext) {
			for (int i = 0; i < originalLetters.length; i++) {
				if (clearLetter == originalLetters[i]) {
					ciphertext.add(secretLetters[i]);
				}
			}
		}
		return ciphertext;
	}
	@Override
	public List<Character> decrypt (List<Character> ciphertext){
		//the text of cipher
		List<Character> cleartext = new LinkedList<Character>();
		
		for(char cipherLetter : ciphertext) {
			for (int i = 0; i < secretLetters.length; i++) {
				if (cipherLetter == secretLetters[i]) {
					cleartext.add(originalLetters[i]);
				}
			}
		}
		return cleartext;
	}
	
}