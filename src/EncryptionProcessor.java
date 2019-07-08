class EncryptionProcessor {
    /**
     * This is the Strategy Class for handling the actual encryption or decryption based on instance state.
     * It takes a String and returns it modified according to the selected method and key.
     */

    private EncryptionAlgorithm algorithm;
    private int key;

    private boolean mode = true; //true - encrypt; false - decrypt

    EncryptionProcessor(EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    void setKey(int key) {
        this.key = key;
    }
    void setMode(boolean mode) {
        this.mode = mode;
    }
    void setAlgorithm(EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    String encryptDecrypt(String data) {
        if (this.mode) {
            return this.algorithm.encrypt(data, this.key);
        }
        else {
            return this.algorithm.decrypt(data, this.key);
        }
    }
    boolean isKeyEmpty() {
        return key == 0;
    }
    boolean isMode() {
        return mode;
    }

}
