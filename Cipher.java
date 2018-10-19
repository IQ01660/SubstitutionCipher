// =============================================================================
/**
 * A <code>Cipher</code> object performs encryption and decryption using a given
 * key.  This class must be extended to define actual
 * encryption/decryption operations.
 *
 * @author Scott F. Kaplan -- sfkaplan@cs.amherst.edua
 **/
// =============================================================================



// =============================================================================
// IMPORTS

import java.util.List;
// =============================================================================



// =============================================================================
public class Cipher {
// =============================================================================



    // =========================================================================
    // DATA MEMBERS

    /**
     * The secret key value used to perform encryption/decryption.
     **/
    private long _key;
    // =========================================================================



    // =========================================================================
    /**
     * The specialized constructor.
     *
     * @param key The key to be used for encryption/decryption operations.
     **/
    public Cipher (long key) {

	_key = key;

    } // Cipher ()
    // =========================================================================



    // =========================================================================
    /**
     * Provide the key.
     *
     * @returns The secret key.
     **/
    public long getKey () {

	return _key;

    } // getKey ()
    // =========================================================================



    // =========================================================================
    /**
     * Encrypt the given cleartext with the key, producing its replacement
     * ciphertext.
     *
     * @param cleartext A list of characters that represent unencrypted data.
     * @returns The ciphertext: a list of characters that represent the
     *          encrypted data.
     **/
    public List<Character> encrypt (List<Character> cleartext){
	//This method should be overridden in SubstitutionCipher
	return null;// stub
    }
    // =========================================================================



    // =========================================================================
    /**
     * Decrypt the given ciphertext with the key, producing its replacement
     * cleartext.
     *
     * @param ciphertext A list of characters that represent encrypted data.
     * @returns The cleartext: a list of characters that represent the
     *          unencrypted data.
     **/
    public List<Character> decrypt (List<Character> ciphertext){
	//This method should be overridden in SubstitutionCipher
	return null;// stub
    }
    // =========================================================================



    // =========================================================================
    /**
     * Given the name of a specific cipher (that must also be a subclass),
     * create an object of that type with the given key.
     *
     * @param cipherName The name of the cipher/subclass to instantiate.
     * @param key The key that the cipher should use.
     * @returns The instantiated cipher/subclass.
     **/
    public static Cipher create (String cipherName, long key) {

	Cipher cipher = null;
	if (cipherName.equals("Caesar")) {
	    cipher = new CaesarCipher(key);
	} else if (cipherName.equals("Substitution")) {
	    cipher = new SubstitutionCipher(key);
	} else {
	    throw new RuntimeException("Cipher.create(): Unknown cipher " +
				       cipherName);
	}

	return cipher;
	
    } // create ()
    // =========================================================================


    
// =============================================================================
} // class Cipher
// =============================================================================
