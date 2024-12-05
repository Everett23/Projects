import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            isValid = validatePassword(password);

            if (!isValid) {
                System.out.println("Password must contain at least 8 characters, including one uppercase letter and one number.");
            }
        }

        System.out.println("Your password is valid!");
        scanner.close();
    }

    private static boolean validatePassword(String password) {
        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letter
        boolean hasUppercase = false;
        // Check for at least one digit
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUppercase && hasDigit;
    }
}
