public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Pola", 21),
                new User("Adam", 32),
                new User("Dawid", 24),
                new User("Tomek", 43)
        };

        int sum = 0;

        for (User user : users) {
            sum += user.age;
        }

        double averageAge = (double) sum / users.length;

        for (User user : users) {
            if (user.age < averageAge) {
                System.out.println(user.name);
            }
        }
    }
}