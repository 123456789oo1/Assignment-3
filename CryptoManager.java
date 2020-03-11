

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		
		boolean check;
		int SIZE = plainText.length();
		
		
		
		for(int i = 0; i < SIZE; i++) {
			
			if(plainText.charAt(i) > UPPER_BOUND || plainText.charAt(i) < LOWER_BOUND) {
				check = false;
				return check;
			}	
				
		}
		
		check = true;
		return check;
		
		
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {

		
		int chr;
		int SIZE = plainText.length();
		String encryptC = "";
		key %= RANGE;
		
		
			for(int i = 0; i < SIZE; i++) {
				
				chr = (int)plainText.charAt(i) + key;
				
				
					while(chr > UPPER_BOUND) {
						
						
						chr -= RANGE;
						
					}
				
				encryptC += (char)chr;
				
			}
		
			
		return encryptC;
			
		
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {

		int bel;
		int chr;
		int SIZE = plainText.length();
		String encryptB = "";

		
			for(int i = 0; i < SIZE; i++) {
				
				
				bel = i % bellasoStr.length();
				
				chr = plainText.charAt(i) + bellasoStr.charAt(bel);
				
					while(chr > UPPER_BOUND) {
						
						
						chr -= RANGE;
						
					}
				
					encryptB += (char)chr;
				
			}
		
		return encryptB;
		
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {


		int chr;
		int SIZE = encryptedText.length();
		String decryptC = "";
		key %= RANGE;
		
		
			for(int i = 0; i < SIZE; i++) {
				
				
				chr = (char)encryptedText.charAt(i) - key;
				
				
					while(chr < LOWER_BOUND) {
						
						
						chr += RANGE;
						
					}
			
			decryptC += (char)chr;
				
				
			}
		
		
			return decryptC;
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {

		

		int bel;
		int chr;
		int SIZE = encryptedText.length();
		String decryptB = "";

		
			for(int i = 0; i < SIZE; i++) {
				
				
				bel = i % bellasoStr.length();
				
				chr = encryptedText.charAt(i) - bellasoStr.charAt(bel);
				
					while(chr < LOWER_BOUND) {
						
						
						chr += RANGE;
						
					}
				
					decryptB += (char)chr;
				
			}
		
		return decryptB;
		
		
	}
	}
