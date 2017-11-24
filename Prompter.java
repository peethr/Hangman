import java.util.Scanner;

public class Prompter {
 
  
  private Game game;
  
  public Prompter(Game game){
   this.game = game; 
  }
  
  public void displayIntro(){
    System.out.println("Welcome to Hangman game! Before you play, please write your name!"); 
  }
  
  public void displayEncourager(){
   System.out.printf("Current best score is %s, you can beat it! %n",game.getBestScore()); 
  }
  
  public void askForName(){
   Scanner scanner = new Scanner(System.in);
   String playerName = scanner.nextLine();
   game.setPlayerName(playerName);
  }
  
  
  public boolean promptForGuess(){
    Scanner scanner = new Scanner(System.in);
    boolean isHit = false;
    boolean isAcceptable = false;
    
    do{
      System.out.print("Enter a letter:   ");
      String guessInput = scanner.nextLine();
      
      try{
      isHit = game.applyGuess(guessInput);
        isAcceptable = true;
      } catch (IllegalArgumentException iae){
        System.out.printf("%s. Please try again %n", iae.getMessage());
      }
    } while(! isAcceptable);
    return isHit;
  }
  
  public void displayProgress(){
    
   System.out.printf("You have %d tries left to solve, %s! Try to solve: %s %n", game.getRemainingTries(), game.getPlayerName() ,game.getCurrentProgress()); 
  }
  
  public void displayOutcome(){
    if(game.isWon()){
	if(game.getRemainingTries() > game.getBestScore())
	{
   	System.out.printf("Congratz! You guessed the word %s correctly with %s tries remaining which is new best score!!! %n",game.getCurrentProgress(), game.getRemainingTries()); 
	}
	else { System.out.printf("Congratz! You guessed the word %s correctly with %s tries remaining! However, best score is %s. %n",game.getCurrentProgress(), game.getRemainingTries(), game.getBestScore());}
    } else {
      System.out.printf("You loose! Correct word was: %s %n", game.getAnswer());
    }
  }
  
}