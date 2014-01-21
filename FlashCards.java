/* FlashCards.java
 * https://github.com/bkvaluemeal/FlashCards
 */

import java.util.Scanner;

public class FlashCards {
	private final static Scanner scanner = new Scanner(System.in);
	private static String name = "";
	private static int score = 0;
	
	/**
	 * Prints the main menu
	 */
	private final static void mainMenu() {
		System.out.println(", please choose a game mode:");
		System.out.println();
		System.out.println("    1. Addition");
		System.out.println("    2. Subtraction");
		System.out.println("    3. Both");
		System.out.println();
		System.out.print("    > ");
	}
	
	/**
	 * Prints the borders for the header
	 * 
	 * @param top
	 * @param length
	 */
	private final static void doLine(boolean top, int length) {
		if(top) {
			System.out.print("╔");
		} else {
			System.out.print("╚");
		}
		for(int i = 2; i < length; i++) {
			System.out.print("═");
		}
		if(top) {
			System.out.println("╗");
		} else {
			System.out.println("╝");
		}
	}
	
	/**
	 * The main loop
	 * 
	 * @param gameMode
	 */
	private final static void loop(int gameMode) {
		String header = "║ Score: " + score + " ║";
		
		// Print header
		System.out.println();
		System.out.println();
		doLine(true, header.length());
		System.out.println(header);
		doLine(false, header.length());
		
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
		if(name.equals("Justin Willis")) {
			name = "Creator";
		}
		System.out.println();
		
		// Welcomes the user
		System.out.print("Welcome " + name);
		
		// Gets the game mode
		while(gameMode < 1 || gameMode > 3) {
			mainMenu();
			
			try {
				gameMode = Integer.parseInt(scanner.nextLine());
			} catch(Exception e) {
				
			}
			
			if(gameMode < 1 || gameMode > 3) {
				System.out.println();
				System.out.print("Sorry... Try that again");
			}
		}
		
		// Starts the main loop
		loop(gameMode);
	}
}
