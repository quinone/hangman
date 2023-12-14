import java.util.Scanner;

public class Gameplay {
	private char[] secretWord;
	private int lives = 6;
	private char[] wordBoard;
	private int blanksCount;
	
	public void setSecretWord(String secret) {
		this.secretWord = secret.toCharArray();
	}
	
	
	public void setBlank(char[] secret) {
		wordBoard = new char[secret.length];
		blanksCount = secret.length;
		for (int i = 0; i < secret.length; i++) {
			this.wordBoard[i] = '_';
		}
	}
	
	public Gameplay(Scanner sc) {
		
		setSecretWord(userInputWord(sc));
		setBlank(secretWord);
		display();
		
		while (lives > 0 && blanksCount > 0) {
			System.out.println();
			boolean correctGuess = false;
			char currentGuess = getGuess(sc);
			for (int i = 0; i < secretWord.length; i++) {
				if (currentGuess == secretWord[i]) {
					wordBoard[i] = secretWord[i];
					correctGuess = true;
					blanksCount--;
				}
				
			}
			if (correctGuess == false) {
				lives--;
			}
			display();
			
		}
		//Loss
		if (lives <= 0) {
			System.out.println("\nYou ran out of lives and died... :'( ");
		}
		//Win
		if (blanksCount == 0) {
			System.out.println("\nCongratulations! You guessed correctly and escaped!");
		}
		
	}
	
	public char getGuess(Scanner sc) {
		System.out.println("Please enter a guess");
		return sc.next().charAt(0);
		
		
	}
	
	//Display prints the hangman and the word board
	public void display() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		Stage stage = new Stage();
		System.out.print(stage.printStage(lives));
		System.out.println(lives);
		for (char c : wordBoard) {
			System.out.print(c + " ");
		}
	}
	
	//Takes input for secretword and clears the screen
	public String userInputWord(Scanner sc) {
		System.out.println("Enter secret word to be guessed: ");
		 String input = sc.next();
		 System.out.print("\033[H\033[2J");
		 System.out.flush();
		 return input;
	}
	
}
