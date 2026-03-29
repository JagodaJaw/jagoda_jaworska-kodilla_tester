package com.kodilla.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersManagerTest {

    @Test
    void testFilterChemistGroupUsernames() {
        // when
        List<String> result = UsersManager.filterChemistGroupUsernames();

        // then
        assertEquals(2, result.size());
        assertTrue(result.contains("Walter White"));
        assertTrue(result.contains("Gale Boetticher"));
    }

    @Test
    void testFilterUsersOlderThan() {
        // when
        List<User> result = UsersManager.filterUsersOlderThan(40);

        // then
        for (User user : result) {
            assertTrue(user.getAge() > 40);
        }
    }

    @Test
    void testFilterUsersWithManyPosts() {
        // when
        List<User> result = UsersManager.filterUsersWithManyPosts(100);

        // then
        for (User user : result) {
            assertTrue(user.getNumberOfPost() > 100);
        }
    }
    @Test
    void testFilterActiveChemistsUsernames() {
        // when
        List<String> result = UsersManager.filterActiveChemistsUsernames(1);

        // then
        assertEquals(2, result.size());
        assertTrue(result.contains("Walter White"));
        assertTrue(result.contains("Gale Boetticher"));
    }
}