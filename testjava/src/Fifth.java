import java.io.*;
import java.util.Scanner;

public class Fifth {

    public static String inputText(String message, Scanner scanner) {
        System.out.println(message);
        System.out.print("> ");
        return scanner.nextLine();
    }

    public static void saveFile(String filename, String content) {
        try {
            File file = new File(filename);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    public static String readFile(String filename) {
        try {
            File file = new File(filename);
            BufferedReader bw = new BufferedReader(new FileReader(file));
            String content = bw.readLine();
            bw.close();
            return content;
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return "";
    }

    public static String changeLowerUpperCase(String text) {
        String newText = "";
        String charValue = "";
        for (int i = 0; i < text.length(); i++) {
            charValue = String.valueOf(text.charAt(i));
            newText += Character.isUpperCase(text.charAt(i)) ? charValue.toLowerCase() : charValue.toUpperCase();
        }
        return newText;
    }

    public static void saveReadChangeText() {
        Scanner scanner = new Scanner(System.in);
        String filename = inputText("Ingrese el nombre del archivo:", scanner) + ".txt";
        String content = inputText("Ingrese el texto del archivo:", scanner);
        saveFile(filename, content);
        String fileContent = changeLowerUpperCase(readFile(filename));
        System.out.println("Respuesta: " + fileContent);
    }

    public static void main(String[] args) {
        saveReadChangeText();
    }
}
