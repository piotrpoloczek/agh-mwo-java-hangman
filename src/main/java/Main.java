package pl.edu.agh.hangman;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Ścieżka do pliku
        String sciezkaDoPliku = "C:\\Users\\User\\IdeaProjects\\agh-mwo-java-hangman\\src\\main\\resources\\slowa.txt";

        ReaderChar wizytator = new ReaderChar(sciezkaDoPliku);

        try {
            // Losowanie i wyświetlenie słowa
            String wylosowaneSlowo = wizytator.wylosujSlowo();
            System.out.println("Wylosowane słowo: " + wylosowaneSlowo);
        } catch (IOException e) {
            System.out.println("Wystąpił błąd: " + e.getMessage());
        }
    }
}