package com.kodilla.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersManagerTest {

    @Test
    void testFilterUsersOlderThan() {
        // when
        List<User> result = UsersManager.filterUsersOlderThan(40);

        // then
        List<User> expected = List.of(
                new User("Walter White", 50, 7, "Chemists"),
                new User("Gus Firing", 49, 0, "Board"),
                new User("Gale Boetticher", 44, 2, "Chemists"),
                new User("Mike Ehrmantraut", 57, 0, "Security")
        );
        assertEquals(expected, result);
    }

    @Test
    void testFilterChemistGroupUsernames() {
        // when
        List<String> result = UsersManager.filterChemistGroupUsernames();

        // then
        List<String> expected = List.of("Walter White", "Gale Boetticher");
        assertEquals(expected, result);
    }

    @Test
    void testFilterActiveChemistsUsernames() {
        // when
        List<String> result = UsersManager.filterActiveChemistsUsernames(5);

        // then
        assertEquals(1, result.size());
        assertEquals("Walter White", result.get(0));
    }

    @Test
    void testFilterUsernamesWithPostsAtLeast() {
        // when
        List<String> result = UsersManager.filterUsernamesWithPostsAtLeast(100);

        // then
        List<String> expected = List.of("Jessie Pinkman", "Tuco Salamanca");
        assertEquals(expected, result);
    }
}
