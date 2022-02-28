import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Third {

    public static String inputPhrase(String message, Scanner scanner) {
        System.out.println(message);
        System.out.print("> ");
        return scanner.nextLine();
    }

    public static String changeToCapitalLetters(String firstPhrase, String secondPhrase) {
        if (!secondPhrase.equals("")) {
            String newPhrase = "";
            HashMap<String, Integer> hashMapPhrase = new HashMap<String, Integer>();
            for (String word : secondPhrase.split(" ")) {
                if (!hashMapPhrase.containsKey(word)) {
                    hashMapPhrase.put(word, 0);
                }
            }
            for (String word : firstPhrase.split(" ")) {
                word = hashMapPhrase.containsKey(word) ? word.toUpperCase() : word;
                newPhrase += word + " ";
            }
            return newPhrase.trim();
        }
        return firstPhrase;
    }

    public static void convertPhrases() {
        Scanner scanner = new Scanner(System.in);
        String firstPhrase = inputPhrase("Ingrese la primera cadena:", scanner);
        String secondPhrase = inputPhrase("Ingrese la segunda cadena:", scanner);
        String newPhrase = changeToCapitalLetters(firstPhrase, secondPhrase);
        System.out.print("Resultado: " + newPhrase);
    }

    public static void main(String[] args) {
        convertPhrases();
    }
}
