package pl.edu.agh.hangman;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock
    private WordReader wordReader;

    @Mock
    private UserInput userInput;

    @Mock
    private UserCharacterChecker userCharacterChecker;

    @InjectMocks
    private Game game;

    @Before
    public void setup() {
        when(userInput.getLetterFromUser()).thenReturn('a', 'b', 'c', 'd', 'e', 'f');
        when(userCharacterChecker.getGuessedWordChars()).thenReturn(new char[] {'\u0000', '\u0000', '\u0000', '\u0000'});
        when(userCharacterChecker.getNumberOfWrongGuesses()).thenReturn(0, 1, 2, 3, 4, 5);
        when(userCharacterChecker.checkIfWordIsGuessed()).thenReturn(false, false, false, false, false, true);
    }

    @Test
    public void testPlay_GameWon() {
        game.play();
        verify(userInput, times(6)).getLetterFromUser();
        verify(userCharacterChecker, times(6)).guessCharacter(anyChar());
        verify(userCharacterChecker, times(6)).getGuessedWordChars();
        verify(userCharacterChecker, times(6)).getNumberOfWrongGuesses();
        verify(userCharacterChecker, times(6)).checkIfWordIsGuessed();
    }

    @Test
    public void testPlay_GameLost() {
        when(userCharacterChecker.getNumberOfWrongGuesses()).thenReturn(0, 1, 2, 3, 4, 5, 6);
        when(userCharacterChecker.checkIfWordIsGuessed()).thenReturn(false, false, false, false, false, false, false);
        game.play();
        verify(userInput, times(7)).getLetterFromUser();
        verify(userCharacterChecker, times(7)).guessCharacter(anyChar());
        verify(userCharacterChecker, times(7)).getGuessedWordChars();
        verify(userCharacterChecker, times(7)).getNumberOfWrongGuesses();
        verify(userCharacterChecker, times(7)).checkIfWordIsGuessed();
    }

    @Test
    public void testPlay_IllegalArgumentException() {
        doThrow(new IllegalArgumentException("Invalid character")).when(userCharacterChecker).guessCharacter(anyChar());
        game.play();
        verify(userInput, times(1)).getLetterFromUser();
        verify(userCharacterChecker, times(1)).guessCharacter(anyChar());
        verify(userCharacterChecker, times(1)).getGuessedWordChars();
        verify(userCharacterChecker, times(1)).getNumberOfWrongGuesses();
        verify(userCharacterChecker, times(1)).checkIfWordIsGuessed();
    }
}