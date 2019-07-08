public class CaesarAlgorithm implements EncryptionAlgorithm {
    /** This algorithm shifts letters of alphabet in a circle, implementation of the Caesar cypher.
     * It currently supports only lower case letters.
     */
    private final String ALPHABET_TABLE = "abcdefghijklmnopqrstuvwxyz";
    private StringBuilder finalizedString = new StringBuilder();
    @Override
    public String encrypt(String data, int key) {
        char[] ary = data.toLowerCase().toCharArray();
        for (char c : ary) {
            String s = c + "";
            if (ALPHABET_TABLE.contains(s)) {
                this.finalizedString.append(encodeCharacter(c,key));
            }
            else {
                this.finalizedString.append(c);
            }
        }
        return this.finalizedString.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        char[] ary = data.toLowerCase().toCharArray();
        for (char c : ary) {
            String s = c + "";
            if (ALPHABET_TABLE.contains(s)) {
                this.finalizedString.append(decodeCharacter(c,key));
            }
            else {
                this.finalizedString.append(c);
            }
        }
        return this.finalizedString.toString();
    }

    private char encodeCharacter(char letter, int key) {
        int index = ALPHABET_TABLE.indexOf(letter) + key;
        if (index > 25) {
            index = index - 26;
        }
        return ALPHABET_TABLE.charAt(index);
    }
    private char decodeCharacter(char letter, int key) {
        int index = ALPHABET_TABLE.indexOf(letter) - key;
        if (index < 0) {
            index = index + 26;
        }
        return ALPHABET_TABLE.charAt(index);
    }
}
