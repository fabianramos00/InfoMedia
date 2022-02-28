import java.util.Objects;
import java.util.Scanner;

public class Second {

    public static String inputText(String message, Scanner scanner) {
        System.out.println(message);
        System.out.print("> ");
        return scanner.next();
    }

    public static void guessSecretWord() {
        Scanner scanner = new Scanner(System.in);
        String secretWord = inputText("Ingrese la palabra secreta:", scanner);
        boolean isCorrect = false;
        int attempts = 0;
        do {
            attempts += 1;
            System.out.println("Adivina la palabra, intento " + attempts + ":");
            System.out.print("> ");
            if (secretWord.equals(scanner.next())) {
                isCorrect = true;
                System.out.print("Palabra correcta");
            }
        } while (!isCorrect && attempts < 3);
        if (!isCorrect) {
            System.out.print("La palabra secreta era: " + secretWord);
        }
    }

    public static void main(String[] args) {
        guessSecretWord();
    }
}
