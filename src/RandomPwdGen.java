import java.util.Random;
import java.util.Scanner;

public class RandomPwdGen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int upperCase = scanner.nextInt();
        int lowerCase = scanner.nextInt();
        int digits = scanner.nextInt();
        int len = scanner.nextInt();
        String password = "";

        while (len > 0) {
            if ((upperCase > 0) && (len > 0)) {
                upperCase--;
                len--;
                if (password.length() > 0) {
                    char c = password.charAt(password.length()-1);
                    password += generateChar(2, c);
                }
                else {
                    password += generateChar(2);
                }
            }
            if ((lowerCase > 0) && (len > 0)) {
                lowerCase--;
                len--;
                if (password.length() > 0) {
                    char c = password.charAt(password.length()-1);
                    password += generateChar(1, c);
                }
                else {
                    password += generateChar(1);
                }
            }
            if ((digits > 0) && (len > 0)) {
                digits--;
                len--;
                if (password.length() > 0) {
                    char c = password.charAt(password.length()-1);
                    password += generateChar(3, c);
                }
                else {
                    password += generateChar(3);
                }
            }
            if ((upperCase + lowerCase + digits == 0) && (len > 0)) {
                if (password.length() > 0) {
                    char c = password.charAt(password.length()-1);
                    password += generateChar(0, c);
                }
                else {
                    password += generateChar(0);
                }
                len--;
            }
        }
        System.out.println(password);
    }

    static char generateChar(int charType) { //0 = undefined; 1 = lower case; 2 = upper case; 3 = digit
        int from;
        int to;
        Random r = new Random();
        if (charType == 2) {
            from = 65;
            to = 90;
        } else if (charType == 1) {
            from = 97;
            to = 122;
        } else if (charType == 3) {
            from = 48;
            to = 57;
        } else {
            from = 65;
            to = 122;
        }
        return (char) (r.nextInt((to - from) + 1) + from);
    }
    static char generateChar(int charType, char lastChar) { //0 = undefined; 1 = lower case; 2 = upper case; 3 = digit
        int from;
        int to;
        Random r = new Random();
        if (charType == 2) {
            from = 65;
            to = 90;
        } else if (charType == 1) {
            from = 97;
            to = 122;
        } else if (charType == 3) {
            from = 48;
            to = 57;
        } else {
            from = 65;
            to = 122;
        }
        char c = (char) (r.nextInt((to - from) + 1) + from);
        while (c == lastChar) {
            c = (char) (r.nextInt((to - from) + 1) + from);
        }
        return c;
    }
}
