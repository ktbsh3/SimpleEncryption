import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileHandler {
    /**
     * Class for handling the extraction of data String, or writing the data String to a specified File.
     */


    FileHandler() {

    }
    // Extracts all lines of file into a String.
    String getContent(String pathToInput) throws FileNotFoundException {
        File input = new File(pathToInput);
        Scanner scanner = new Scanner(input);
        StringBuilder content = new StringBuilder();
        while (scanner.hasNext()) {
            content.append(scanner.nextLine());
        }
        scanner.close();
        return content.toString();
    }
    // Writes a string to file specified, if the file doesn't exists, it's created automatically.
    // OVERWRITES CONTENTS OF AN EXISTING FILE.
    void writeContent(String content, String pathToOutput) {
        File output = new File(pathToOutput);
        try (FileWriter fileWriter = new FileWriter(output)) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
