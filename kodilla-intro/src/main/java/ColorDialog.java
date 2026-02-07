import java.util.Scanner;

public class ColorDialog {

    public static String getColorLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first letter of color (r, g, b):");
        return scanner.nextLine();
    }

    public static String getColorName(String letter) {
        if (letter == null || letter.isEmpty()) {
            return "No color provided";
        }

        letter = letter.toLowerCase();

        switch (letter) {
            case "r":
                return "red";
            case "g":
                return "green";
            case "b":
                return "blue";
            default:
                return "Unknown color";
        }
    }
}