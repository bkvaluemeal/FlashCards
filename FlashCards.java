/* FlashCards.java
 * https://github.com/bkvaluemeal/FlashCards
 */

import java.util.Scanner;

public class FlashCards {
	private final static Scanner scanner = new Scanner(System.in);
	private static String name = "";
	
	private final static void mainMenu() {
		System.out.println(", please choose a game mode:");
		System.out.println();
		System.out.println("    1. Addition");
		System.out.println("    2. Subtraction");
		System.out.println("    3. Both");
		System.out.println();
		System.out.print("    > ");
	}
	
	private final static void loop(int gameMode) {
		switch(gameMode) {
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
			break;
		case 3:
			System.out.println(3);
			break;
		}
	}
	
	public static void main(String args[]) {
		int gameMode = 0;
		
		// Gets user's name
		System.out.print("Enter your name: ");
		name = scanner.nextLine().trim();
		if(name.equals("") || name.matches(".*\\d.*") || name.isEmpty()) {
			name = "Annon";
		}
		System.out.println();
		
		// Welcomes the user
		System.out.print("Welcome " + name);
		
		// Gets the game mode
		while(gameMode < 1 || gameMode > 3) {
			mainMenu();
			
			try{
				gameMode = Integer.parseInt(scanner.nextLine());
			} finally {
				if(gameMode < 1 || gameMode > 3) {
					System.out.println();
					System.out.print("Sorry... Try that again");
				}
			}
		}
		
		System.out.println();
		
		// Starts the main loop
		loop(gameMode);
	}
}
