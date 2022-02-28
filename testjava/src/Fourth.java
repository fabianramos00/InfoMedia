import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Fourth {

    public static int countVocals(String sentence) {
        sentence = sentence.replace(" ", "").toLowerCase();
        System.out.print(sentence);
        int vocalsCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if ("aeiou".contains(String.valueOf(sentence.charAt(i)))) vocalsCount++;
        }
        return vocalsCount;
    }

    public static void checkVocalsQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una palabra o frase");
        System.out.print("> ");
        String sentence = scanner.nextLine();
        System.out.print("La palabra o frase contiene " + countVocals(sentence) + " vocales");
    }

    public static void main(String[] args) {
        checkVocalsQuantity();
    }
}
