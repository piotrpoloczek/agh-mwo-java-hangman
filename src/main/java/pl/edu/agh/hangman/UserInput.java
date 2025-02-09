package pl.edu.agh.hangman;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner;

    public UserInput() {

        this.scanner = new Scanner(System.in);
    }

    public char getLetterFromUser() {
        char letter;

        while (true) {
            System.out.print("Please provide letter: ");
            String input = scanner.next();

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                letter = input.charAt(0);
                break;
            } else {
                System.out.println("This is not a letter.");
            }
        }
        return letter;
    }

    public void closeScanner() {
        scanner.close();
        }
    }