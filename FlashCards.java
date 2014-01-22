/* FlashCards.java
 * https://github.com/bkvaluemeal/FlashCards
 */

import java.util.Random;
import java.util.Scanner;

public class FlashCards {
	private final static Scanner scanner = new Scanner(System.in);
	private final static Random random = new Random();
	private static String name = "";
	private static int score = 0;
	private static int lives = 5;
	
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
	 * @param length
	 */
	private final static void doLine(int length) {
		System.out.print("+");
		for(int i = 2; i < length; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
	
	/**
	 * Prints the correct splash
	 */
	private final static void correct() {
		System.out.println();
		System.out.println("   _____ ____  _____  _____  ______ _____ _______ ");
		System.out.println("  / ____/ __ \\|  __ \\|  __ \\|  ____/ ____|__   __|");
		System.out.println(" | |   | |  | | |__) | |__) | |__ | |       | |   ");
		System.out.println(" | |   | |  | |  _  /|  _  /|  __|| |       | |   ");
		System.out.println(" | |___| |__| | | \\ \\| | \\ \\| |___| |____   | |   ");
		System.out.println("  \\_____\\____/|_|  \\_\\_|  \\_\\______\\_____|  |_|   ");
	}
	
	/**
	 * The main loop
	 * 
	 * @param gameMode
	 */
	private final static void loop(int gameMode) {
		while(lives > 0) {
			boolean addition = random.nextBoolean();
			
			// Makes the header
			String header = "| ";
			if(addition || gameMode == 1) {
				header += "Addition ";
			} else {
				header += "Subtraction ";
			}
			header += "| Score: " + score + " | Lives: " + lives + " |";
			
			int randA = random.nextInt(99);
			int randB = random.nextInt(99);
			int answer = 0;
			
			// Print header
			System.out.println();
			System.out.println();
			doLine(header.length());
			System.out.println(header);
			doLine(header.length());
			
			switch(gameMode) {
			case 1:
				answer = randA + randB;
				System.out.print(randA + " + " + randB + " = ");
				try {
					if(Integer.parseInt(scanner.nextLine().trim()) == answer) {
						score++;
						correct();
					} else {
						lives--;
					}
				} catch(Exception e) {
					
				}
				break;
			case 2:
				answer = randA - randB;
				System.out.print(randA + " - " + randB + " = ");
				try {
					if(Integer.parseInt(scanner.nextLine().trim()) == answer) {
						score++;
						correct();
					} else {
						lives--;
					}
				} catch(Exception e) {
					
				}
				break;
			case 3:
				if(addition) {
					answer = randA + randB;
					System.out.print(randA + " + " + randB + " = ");
				} else {
					answer = randA - randB;
					System.out.print(randA + " - " + randB + " = ");
				}
				try {
					if(Integer.parseInt(scanner.nextLine().trim()) == answer) {
						score++;
						correct();
					} else {
						lives--;
					}
				} catch(Exception e) {
					
				}
				break;
			}
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
		
		// Prints score
		System.out.println();
		if(score > 0) {
			System.out.println("Good job " + name + "! You got " + score + " right.");
		} else {
			System.out.println("Wow " + name + ", L2Math! You got " + score + " right.");
		}
	}
}
