public class UnicodeShiftAlgorithm implements EncryptionAlgorithm {
    /**
     * This class is the implementation of an encryption algorithm which shifts any character by x spaces in the unicode table
     */

    @Override
    public String encrypt(String data, int key) {
        char[] charAry = data.toCharArray();
        StringBuilder encrypted = new StringBuilder();
        for (char c1 : charAry) {
            char c = c1;
            c += key;
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        char[] charAry = data.toCharArray();
        StringBuilder decrypted = new StringBuilder();
        for (char c1 : charAry) {
            char c = c1;
            c -= key;
            decrypted.append(c);
        }
        return decrypted.toString();
    }
}
