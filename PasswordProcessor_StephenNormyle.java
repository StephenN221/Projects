import java.util.Scanner;

public class PasswordProcessor_StephenNormyle {

	public static void main(String[] args) throws PasswordException_StephenNormyle {
		Scanner input = new Scanner(System.in);
		String moveOn = "No";
		do {
			System.out.println("User name:");
			String username = input.nextLine();
			System.out.println("Password:");
			String password = input.nextLine();

			if (isValid(password)) System.out.println("Hooray, the password is valid.");

			System.out.println("Continue?Y(for yes) or N(for No):");
			moveOn = input.nextLine();
		} while (moveOn.toUpperCase().charAt(0) == 'Y');
		System.out.println("Good Bye!");
	}

	public static boolean isValid(String password) throws PasswordException_StephenNormyle {
		int passwordLength = password.length();

		if (passwordLength < 8) {
			throw new PasswordException_StephenNormyle("Password must contain 8 or more characters.");
		}
		if (password.toUpperCase().charAt(0) < 'A' && password.toUpperCase().charAt(0) > 'Z') {
			throw new PasswordException_StephenNormyle("Password must start with a letter.");
		}
		boolean containsDigit = false;
		boolean containsLetter = false;
		boolean containsSpecial = false;
		for (int i = 0; i < (int) password.length(); i++) {
			char c = password.toUpperCase().charAt(i);
			if (c > 64 && c < 91) containsLetter = true;
			if (c > 47 && c < 58) containsDigit = true;
			if (c > 32 && c < 39) containsSpecial = true;
		}
		if (!containsLetter || !containsDigit) {
			throw new PasswordException_StephenNormyle("Password must contain both letters and digits.");
		}
		if (!containsSpecial) {
			throw new PasswordException_StephenNormyle("Password must contain at least one special character.");
		}
		else return true;
		}

	}



