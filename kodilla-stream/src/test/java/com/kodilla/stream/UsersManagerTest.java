package com.kodilla.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersManagerTest {

    @Test
    void testFilterUsersOlderThan() {
        List<User> users = List.of(
                new User("A", 20, 1, "X"),
                new User("B", 40, 2, "Y"),
                new User("C", 50, 3, "Z")
        );

        UsersManager manager = new UsersManager(users);

        List<User> result = manager.filterUsersOlderThan(30);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(u -> u.getAge() > 30));
    }

    @Test
    void testFilterChemistGroupUsernames() {
        List<User> users = List.of(
                new User("Walter White", 50, 7, "Chemists"),
                new User("Jesse Pinkman", 25, 4648, "Sales"),
                new User("Gale", 44, 2, "Chemists")
        );

        UsersManager manager = new UsersManager(users);

        List<String> result = manager.filterChemistGroupUsernames();

        assertEquals(2, result.size());
        assertTrue(result.contains("Walter White"));
        assertTrue(result.contains("Gale"));
    }

    @Test
    void testFilterActiveChemistsUsernames() {
        List<User> users = List.of(
                new User("Walter White", 50, 7, "Chemists"),
                new User("Gale", 44, 2, "Chemists"),
                new User("Jesse", 30, 100, "Sales")
        );

        UsersManager manager = new UsersManager(users);

        List<String> result = manager.filterActiveChemistsUsernames(5);

        assertEquals(1, result.size());
        assertEquals("Walter White", result.get(0));
    }
}