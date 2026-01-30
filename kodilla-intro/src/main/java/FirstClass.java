public class FirstClass {
    public static void main(String[] args) {

                Notebook notebook = new Notebook(800, 500, 2020);
                Notebook heavyNotebook = new Notebook(2200, 1800, 2022);
                Notebook oldNotebook = new Notebook(1200, 600, 2000);

                notebook.checkPrice();
                notebook.checkWeight();
                notebook.checkYearAndPrice();

                heavyNotebook.checkPrice();
                heavyNotebook.checkWeight();
                heavyNotebook.checkYearAndPrice();

                oldNotebook.checkPrice();
                oldNotebook.checkWeight();
                oldNotebook.checkYearAndPrice();
            }
        }