import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Initialize all required fields and classes
        Scanner scanner = new Scanner(System.in);
        String data = null;
        String in;
        String out = null;
        String processedData;
        FileHandler fh = new FileHandler();
        EncryptionProcessor ep = new EncryptionProcessor(new UnicodeShiftAlgorithm()); // Default mode is unicode shift


        // command line argument initialization
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    if (args[i+1].equals("dec")) {
                        ep.setMode(false);
                    }
                    else if (args[i+1].equals("enc")) {
                        ep.setMode(true);
                    }
                    else {
                        System.out.println("Incorrect -mode argument, please use \"enc\" or \"dec\".\n\rUsing encryption mode now.");
                    }
                    break;
                case "-key":
                    ep.setKey(Integer.parseInt(args[i+1]));
                    break;
                case "-data":
                    data = args[i+1];
                    break;
                case "-in":
                    in = args[i+1];
                    try {
                        data = fh.getContent(in);
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found, please enter correct path: ");
                        in = scanner.nextLine();
                    }
                    break;
                case "-out":
                    out = args[i+1];
                    break;
                case "-alg":
                    String algorithm = args[i+1];
                    if (algorithm.equals("shift")) {
                        ep.setAlgorithm(new CaesarAlgorithm());
                    }
                    else if (algorithm.equals("unicode")) {
                        ep.setAlgorithm(new UnicodeShiftAlgorithm());
                    }
                    else {
                        System.out.println("Incorrect -alg argument, please use \"shift\" or \"unicode\".\n\rUsing unicode now.");
                    }
                    break;

            }
        }

        if (ep.isKeyEmpty()) {
            System.out.println("Encryption key seems to be empty or 0, please specify a value: ");
            ep.setKey(Integer.parseInt(scanner.nextLine()));
        }
        if (data != null) {
            processedData = ep.encryptDecrypt(data);
        }
        // No data was detected, asking user to provide by stdin
        else {
            if (ep.isMode()) {
                System.out.println("Please input string to encrypt: ");
            }
            else {
                System.out.println("Please input string to decrypt: ");
            }
            data = scanner.nextLine();
            processedData = ep.encryptDecrypt(data);
        }


        // Invocations for handling output, either a file if specified and data String is written to it, or the data String is printed by standard output.
        if (out != null) {
            fh.writeContent(processedData, out);
        }
        else {
            System.out.println(processedData);
        }

    }
}
