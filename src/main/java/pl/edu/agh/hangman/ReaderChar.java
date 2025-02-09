package pl.edu.agh.hangman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

        public class ReaderChar {
            private String sciezkaDoPliku;

            public ReaderChar(String sciezkaDoPliku) {
                this.sciezkaDoPliku = sciezkaDoPliku;
            }

            public String wylosujSlowo() throws IOException {
                List<String> slowa = new ArrayList<>();

                // Wczytanie słów z pliku do listy
                try (BufferedReader br = new BufferedReader(new FileReader(sciezkaDoPliku))) {
                    String linia;
                    while ((linia = br.readLine()) != null) {
                        slowa.add(linia.trim()); // Dodajemy linie jako słowa, usuwając białe znaki
                    }
                }

                // Sprawdzenie, czy lista nie jest pusta
                if (slowa.isEmpty()) {
                    throw new IOException("Plik jest pusty lub nie zawiera żadnych słów.");
                }

                // Losowanie słowa z listy
                Random random = new Random();
                int indeks = random.nextInt(slowa.size());
                return slowa.get(indeks);
            }
        }
