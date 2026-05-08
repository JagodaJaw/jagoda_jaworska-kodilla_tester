package execution_model.homework;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest {

    @Test
    public void shouldAddOnlyUniqueOrders() {
        //Given
        Shop shop = new Shop();
        Order order = order(120.00, 2026, 5, 1, "user1");

        //When
        shop.addOrder(order);
        shop.addOrder(order);
        shop.addOrder(order(120.00, 2026, 5, 1, "user1"));

        //Then
        assertEquals(1, shop.getNumberOfOrders());
    }

    @Test
    public void shouldReturnOrdersFromDateRangeIncludingBoundaries() {
        //Given
        Order secondOrder = order(120.00, 2026, 5, 1, "user2");
        Order thirdOrder = order(240.00, 2026, 5, 3, "user3");
        Shop shop = shopWith(
                order(80.00, 2026, 4, 30, "user1"),
                secondOrder,
                thirdOrder,
                order(300.00, 2026, 5, 4, "user4"));

        //When
        List<Order> result = shop.getOrdersFromDateRange(
                LocalDate.of(2026, 5, 1),
                LocalDate.of(2026, 5, 3));

        //Then
        assertEquals(2, result.size());
        assertTrue(result.contains(secondOrder));
        assertTrue(result.contains(thirdOrder));
    }

    @Test
    public void shouldReturnOrdersFromValueRangeIncludingBoundaries() {
        //Given
        Order secondOrder = order(120.00, 2026, 5, 1, "user2");
        Order thirdOrder = order(240.00, 2026, 5, 3, "user3");
        Shop shop = shopWith(
                order(80.00, 2026, 4, 30, "user1"),
                secondOrder,
                thirdOrder,
                order(300.00, 2026, 5, 4, "user4"));

        //When
        List<Order> result = shop.getOrdersFromValueRange(120.00, 240.00);

        //Then
        assertEquals(2, result.size());
        assertTrue(result.contains(secondOrder));
        assertTrue(result.contains(thirdOrder));
    }

    @Test
    public void shouldReturnNumberOfOrders() {
        //Given
        Shop shop = shopWith(
                order(80.00, 2026, 4, 30, "user1"),
                order(120.00, 2026, 5, 1, "user2"),
                order(240.00, 2026, 5, 3, "user3"));

        //When
        int result = shop.getNumberOfOrders();

        //Then
        assertEquals(3, result);
    }

    @Test
    public void shouldReturnTotalValueOfOrders() {
        //Given
        Shop shop = shopWith(
                order(80.00, 2026, 4, 30, "user1"),
                order(120.00, 2026, 5, 1, "user2"),
                order(240.00, 2026, 5, 3, "user3"));

        //When
        double result = shop.getTotalValue();

        //Then
        assertEquals(440.00, result, 0.01);
    }

    @Test
    public void shouldReturnEmptyListFromDateRangeForEmptyShop() {
        //Given
        Shop shop = new Shop();

        //When
        List<Order> result = shop.getOrdersFromDateRange(
                LocalDate.of(2026, 5, 1),
                LocalDate.of(2026, 5, 3));

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnEmptyListFromValueRangeForEmptyShop() {
        //Given
        Shop shop = new Shop();

        //When
        List<Order> result = shop.getOrdersFromValueRange(100.00, 250.00);

        //Then
        assertTrue(result.isEmpty());
    }

    @Test
    public void shouldReturnZeroOrderCountForEmptyShop() {
        //Given
        Shop shop = new Shop();

        //When
        int result = shop.getNumberOfOrders();

        //Then
        assertEquals(0, result);
    }

    @Test
    public void shouldReturnZeroTotalValueForEmptyShop() {
        //Given
        Shop shop = new Shop();

        //When
        double result = shop.getTotalValue();

        //Then
        assertEquals(0.00, result, 0.01);
    }

    @Test
    public void shouldReturnOrdersFromDateRangeWhenStartDateEqualsEndDate() {
        //Given
        Order orderFromSelectedDate = order(120.00, 2026, 5, 1, "user2");
        Shop shop = shopWith(
                order(80.00, 2026, 4, 30, "user1"),
                orderFromSelectedDate,
                order(240.00, 2026, 5, 3, "user3"));

        //When
        List<Order> result = shop.getOrdersFromDateRange(
                LocalDate.of(2026, 5, 1),
                LocalDate.of(2026, 5, 1));

        //Then
        assertEquals(List.of(orderFromSelectedDate), result);
    }

    @Test
    public void shouldThrowExceptionWhenDateRangeIsInvalid() {
        //Given
        Shop shop = new Shop();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> shop.getOrdersFromDateRange(
                LocalDate.of(2026, 5, 3),
                LocalDate.of(2026, 5, 1)));
    }

    @Test
    public void shouldThrowExceptionWhenValueRangeIsInvalid() {
        //Given
        Shop shop = new Shop();

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> shop.getOrdersFromValueRange(250.00, 100.00));
    }

    @Test
    public void shouldThrowExceptionWhenAddingNullOrder() {
        //Given
        Shop shop = new Shop();

        //When & Then
        assertThrows(NullPointerException.class, () -> shop.addOrder(null));
    }

    @Test
    public void shouldThrowExceptionWhenDateRangeContainsNullStartDate() {
        //Given
        Shop shop = new Shop();

        //When & Then
        assertThrows(NullPointerException.class, () -> shop.getOrdersFromDateRange(null, LocalDate.of(2026, 5, 3)));
    }

    @Test
    public void shouldThrowExceptionWhenDateRangeContainsNullEndDate() {
        //Given
        Shop shop = new Shop();

        //When & Then
        assertThrows(NullPointerException.class, () -> shop.getOrdersFromDateRange(LocalDate.of(2026, 5, 1), null));
    }

    @Test
    public void shouldThrowExceptionWhenOrderContainsNull() {
        //When & Then
        assertThrows(NullPointerException.class, () -> new Order(120.00, null, "user1"));
        assertThrows(NullPointerException.class, () -> new Order(120.00, LocalDate.of(2026, 5, 1), null));
    }

    private Shop shopWith(Order... orders) {
        Shop shop = new Shop();
        Arrays.stream(orders).forEach(shop::addOrder);
        return shop;
    }

    private Order order(double value, int year, int month, int day, String userLogin) {
        return new Order(value, LocalDate.of(year, month, day), userLogin);
    }
}
