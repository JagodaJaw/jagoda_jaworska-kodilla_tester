public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
public static void main(String[] args) {
    System.out.println(LeapYear.isLeapYear(2024)); // true
    System.out.println(LeapYear.isLeapYear(1900)); // false
    System.out.println(LeapYear.isLeapYear(2000)); // true
}
}