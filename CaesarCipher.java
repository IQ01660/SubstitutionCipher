// =============================================================================
/**
 * The <code>CaesarCipher</code> encrypts/decrypts by shifting each cleartext
 * character by a fixed number of positions in the alphabet (given by the key)
 * forward/backward, respectively.
 *
 * @author Scott F. Kaplan -- sfkaplan@cs.amherst.edua
 **/
// =============================================================================



// =============================================================================
// IMPORTS

import java.util.List;
import java.util.LinkedList;
// =============================================================================



// =============================================================================
public class CaesarCipher extends Cipher {
// =============================================================================



    // =========================================================================
    /**
     * The specialized constructor.
     *
     * @param key The key to used to shift each character for
     * encryption/decryption.
     **/
    public CaesarCipher (long key) {

	super(key);

    } // CaesarCipher ()
    // =========================================================================



    // =========================================================================
    /**
     * Replace each character in the given cleartext by shifting forward, by the
     * number of positions specified by the key, each character.
     *
     * @param cleartext The unencrypted source data.
     * @returns The ciphertext -- the encrypted result.
     **/
    public List<Character> encrypt (List<Character> cleartext) {

	List<Character> ciphertext = new LinkedList<Character>();

	// Shift each character of the cleartext, appending the result to the
	// ciphertext.  Assume an English encoding with 256 possible character
	// values, wrapping around any shifts beyond a value of 255.
	for (char clearchar : cleartext) {

	    char cipherchar = (char)((clearchar + getKey()) % 256);
	    ciphertext.add(cipherchar);

	}

	return ciphertext;
	
    } // encrypt ()
    // =========================================================================
    


    // =========================================================================
    /**
     * Replace each character in the given ciphertext by shifting backward, by
     * the number of positions specified by the key, each character.
     *
     * @param ciphertext The encrypted source data.
     * @returns The cleartext -- the decrypted result.
     **/
    public List<Character> decrypt (List<Character> ciphertext) {

	List<Character> cleartext = new LinkedList<Character>();

	// Shift each character of the cleartext, appending the result to the
	// ciphertext.  Assume an English encoding with 256 possible character
	// values, wrapping around any shifts beyond a value of 255.
	for (char cipherchar : ciphertext) {

	    char clearchar = (char)((cipherchar - getKey()) % 256);
	    cleartext.add(clearchar);

	}

	return cleartext;
	
    } // decrypt ()
    // =========================================================================



// =============================================================================    
} // class CaesarCipher
// =============================================================================
