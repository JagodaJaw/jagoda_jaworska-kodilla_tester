package com.kodilla.exception.homework;

public class WarehouseApp {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        warehouse.addOrder(new Order("1"));
        warehouse.addOrder(new Order("2"));
        warehouse.addOrder(new Order("3"));

        try {
            Order order = warehouse.getOrder("4");
            System.out.println("Found order: " + order.getNumber());

        } catch (OrderDoesntExistException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}