package execution_model.homework;

import java.time.LocalDate;
import java.util.Objects;

public class Order {

    private final double value;
    private final LocalDate date;
    private final String userLogin;

    public Order(double value, LocalDate date, String userLogin) {
        this.value = value;
        this.date = Objects.requireNonNull(date);
        this.userLogin = Objects.requireNonNull(userLogin);
    }

    public double getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUserLogin() {
        return userLogin;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Order order = (Order) object;
        return Double.compare(value, order.value) == 0 &&
                Objects.equals(date, order.date) &&
                Objects.equals(userLogin, order.userLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, date, userLogin);
    }
}
