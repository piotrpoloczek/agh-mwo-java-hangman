package pl.edu.agh.hangman;

public class Game {

    private WordReader wordReader;
    private UserInput userInput;
    private UserCharacterChecker userCharacterChecker;


    public Game(WordReader wordReader, UserInput userInput, UserCharacterChecker userCharacterChecker) {
        this.wordReader = wordReader;
        this.userInput = userInput;
        this.userCharacterChecker = userCharacterChecker;
    }

    public void play(){
        while (true) {
            char character = userInput.getLetterFromUser();

            try{
                userCharacterChecker.guessCharacter(character);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            System.out.println(userCharacterChecker.getGuessedWordChars());
            System.out.println(userCharacterChecker.getNumberOfWrongGuesses());

            if(userCharacterChecker.getNumberOfWrongGuesses() >= 6){
                System.out.println("You lost!");
                break;
            }

            if(userCharacterChecker.checkIfWordIsGuessed()){
                System.out.println("You won!");
                break;
            }
        }
    }
}
