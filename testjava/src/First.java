import java.util.Objects;
import java.util.Scanner;

public class First {

    public static double inputNumber(String message, Scanner scanner) {
        boolean isCorrect = false;
        double value = 0;
        do {
            try {
                System.out.println(message);
                System.out.print("> ");
                value = Double.parseDouble(scanner.next());
                isCorrect = true;
            } catch (NumberFormatException e) {
                System.out.println("Formato incorrecto");
            }
        } while (!isCorrect);
        return value;
    }

    public static void calculateHypotenuse() {
        Scanner scanner = new Scanner(System.in);
        double hick1 = inputNumber("Ingrese el valor del 1er cateto:", scanner);
        double hick2 = inputNumber("Ingrese el valor del 2do cateto:", scanner);
        double value = Math.sqrt(Math.pow(hick1, 2) + Math.pow(hick2, 2));
        System.out.print("El valor de la hipotenusa es " + value);
    }

    public static void main(String[] args) {
        calculateHypotenuse();
    }
}
