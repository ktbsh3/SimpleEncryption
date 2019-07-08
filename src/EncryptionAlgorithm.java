public interface EncryptionAlgorithm {
    /**
     * Interface to define the base encryption methods
     */
    String encrypt(String data, int key);
    String decrypt(String data, int key);
}
