/* FlashCards.java
 * https://github.com/bkvaluemeal/FlashCards
 */

import java.util.Scanner;

public class FlashCards {
	private final static Scanner scanner = new Scanner(System.in);
	private static String name = "";
	private static int gameMode;
	
	private final static void mainMenu() {
		System.out.println();
		System.out.println("    1. Addition");
		System.out.println("    2. Subtraction");
		System.out.println("    3. Both");
		System.out.println();
	}
	
	public static void main(String args[]) {
		// Gets user's name
		System.out.print("Enter your name: ");
		name = scanner.nextLine();
		System.out.println();
		
		// Welcomes the user
		System.out.println("Welcome " + name + ", please choose a game mode:");
		mainMenu();
		System.out.print("    > ");
		
		// Gets the game mode
		gameMode = Integer.parseInt(scanner.nextLine());
	}
}
