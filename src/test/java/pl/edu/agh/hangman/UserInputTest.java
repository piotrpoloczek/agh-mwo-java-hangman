package pl.edu.agh.hangman;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest
{
    private UserInput userInput;

    @BeforeEach
    void setUp() {
        userInput = new UserInput();
    }

    @Test
   public void testValidLowerCaseLetter() {
        System.setIn(new ByteArrayInputStream("a\n".getBytes()));
        userInput = new UserInput();

        char result = userInput.getLetterFromUser();
        assertEquals('a', result, "return a");
    }

    @Test
   public void testValidUpperCaseLetter() {
        System.setIn(new ByteArrayInputStream("Z\n".getBytes()));
        userInput = new UserInput();

        char result = userInput.getLetterFromUser();
        assertEquals('Z', result, "return z");
    }

    @Test
    public void testInvalidThenValidInput() {
        System.setIn(new ByteArrayInputStream("1\n@\nX\n".getBytes()));
        userInput = new UserInput();

        char result = userInput.getLetterFromUser();
        assertEquals('X', result, "return X after invalid inputs");
    }
}

