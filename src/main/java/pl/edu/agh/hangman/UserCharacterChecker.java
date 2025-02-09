package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.Arrays;

public class UserCharacterChecker {

    private char[] finalWordChars;
    private char[] guessedWordChars;
    private ArrayList<Character> userGuessList;


    public UserCharacterChecker(char[] finalWordChars) {
        this.finalWordChars = finalWordChars;
        this.guessedWordChars = new char[finalWordChars.length];
        this.userGuessList = new ArrayList<>();
    }

    public void guessCharacter(char character){
        addCharacterToUsserGuessList(character);
        compareGuessWithWord(character);
    }

    private void compareGuessWithWord(char character){
        for(int i = 0; i < finalWordChars.length; i++){
            if(finalWordChars[i] == character){
                guessedWordChars[i] = character;
            }
        }
    }

    private boolean checkIfCharacterWasGuessedEarlier(char character){
        if(this.userGuessList.contains(character)){
            return true;
        }
        return false;
    }

    private void addCharacterToUsserGuessList(char character){
        if(checkIfCharacterWasGuessedEarlier(character)){
            throw new IllegalArgumentException("You already guessed this letter.");
        }else{
            this.userGuessList.add(character);
        }
    }

    public char[] getGuessedWordChars(){
        return this.guessedWordChars;
    }

    public boolean checkIfWordIsGuessed(){
        if(Arrays.equals(this.guessedWordChars, this.finalWordChars)){
            return true;
        }
        return false;
    }

    public int getNumberOfWrongGuesses(){
        return this.userGuessList.size() - this.getNumberOfRightGuesses();
    }

    private int getNumberOfRightGuesses(){
        int countGuesses = 0;
        for(int i = 0; i < this.guessedWordChars.length; i++){
            if(this.guessedWordChars[i] != '\u0000'){
                countGuesses++;
            }
        }
        return countGuesses;
    }
}
