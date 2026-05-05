package com.kodilla.exception.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    @Test
    void shouldReturnOrderWhenOrderExists() throws OrderDoesntExistException {
        // given
        Warehouse warehouse = new Warehouse();
        Order expectedOrder = new Order("A1");
        warehouse.addOrder(expectedOrder);

        // when
        Order result = warehouse.getOrder("A1");

        // then
        assertEquals(expectedOrder, result);
        assertEquals("A1", result.getNumber());
    }

    @Test
    void shouldThrowExceptionWhenOrderDoesNotExist() {
        // given
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("A1"));

        // when & then
        OrderDoesntExistException exception =
                assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("B2"));
        assertEquals("Order with number B2 does not exist", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenOrderNumberIsNull() {
        // when & then
        assertThrows(NullPointerException.class, () -> new Order(null));
    }

    @Test
    void shouldThrowExceptionWhenAddedOrderIsNull() {
        // given
        Warehouse warehouse = new Warehouse();

        // when & then
        assertThrows(NullPointerException.class, () -> warehouse.addOrder(null));
    }

    @Test
    void shouldThrowExceptionWhenRequestedOrderNumberIsNull() {
        // given
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("A1"));

        // when & then
        assertThrows(NullPointerException.class, () -> warehouse.getOrder(null));
    }
}
