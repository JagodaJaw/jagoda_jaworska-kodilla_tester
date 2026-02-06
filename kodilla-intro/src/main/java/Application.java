public class Application {
    public static void main(String[] args) {

        String letter = ColorDialog.getColorLetter();
        String color = ColorDialog.getColorName(letter);

        System.out.println("Wybrany kolor to: " + color);
    }
}

