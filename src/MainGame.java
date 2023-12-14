import java.util.Scanner;

public class MainGame {
	private char quit = 'q';
	private char newGame = 'n';
	private String secretWord = "hello";
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//new MainGame().mainMenu(sc);
		new MainGame(sc);
		sc.close();
		}
	
	public MainGame(Scanner sc) {
		Gameplay g1 = new Gameplay(sc);
		
	}
	
	public void setSecretWord(String word){
		this.secretWord = word;
	}
	
	public String getSecretWord() {
		return secretWord;
	}

}
