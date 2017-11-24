public class Game {
 
  private final String answer;
  private String playerName;
  private String hits;
  private String misses;
  public static final int MAX_MISSES = 7;
  private int BEST_SCORE = 5;
  
  // Sets the name of player;

  public void setPlayerName(String playerName){
   this.playerName = playerName;  
  }
  
  public String getPlayerName(){
   return playerName; 
  }
  
  public Game(String answer){
   this.answer = answer.toLowerCase();
    hits = "";
    misses = "";
  }
  
  private char normalizeGuess(char letter){
   if(! Character.isLetter(letter)){
    throw new IllegalArgumentException("A letter is required!"); 
   }
   letter = Character.toLowerCase(letter);
    if (hits.indexOf(letter) !=-1 || misses.indexOf(letter) !=-1){
      throw new IllegalArgumentException(letter + " has already been guesses");
    }
    return letter;
  }
  
  public boolean applyGuess(String letters){
   if (letters.length() == 0){
    throw new IllegalArgumentException("No letter found"); 
   }
    return applyGuess(letters.charAt(0));
  }
  
  public boolean applyGuess(char letter){
    letter = normalizeGuess(letter);
     boolean isHit= answer.indexOf(letter) != -1;
    if (isHit){
     hits += letter; 
    }
    else {
     misses += letter; 
    }
    return isHit;   
  }
  
  public String getCurrentProgress(){
   String progress = "";
    for (char letter : answer.toCharArray()){
     char display = '_';
      if(hits.indexOf(letter) != -1){
       display = letter; 
      }
      progress += display;
    }
    return progress; 
  }
  
  public int getRemainingTries(){
   return MAX_MISSES - misses.length(); 
  }
  
  public boolean isWon(){
   
    return getCurrentProgress().indexOf('_') == -1;
    
  }
  
  public String getAnswer (){
    return answer;
  }
  
  public int getBestScore(){
   return BEST_SCORE; 
  }
  
  public void setBestScore(int BEST_SCORE){
    this.BEST_SCORE = BEST_SCORE;
  }

}