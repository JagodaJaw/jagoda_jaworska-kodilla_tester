package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForumStatsTest {

    private final ForumStats stats = new ForumStats();

    @Test
    void testAveragePostsAbove40() {
        // given
        List<User> users = List.of(
                new User("A", 50, 10, "X"),
                new User("B", 45, 20, "X"),
                new User("C", 30, 100, "X")
        );

        // when
        double result = stats.averagePostsAbove40(users);

        // then
        assertEquals(15.0, result);
    }

    @Test
    void testAveragePostsBelow40() {
        // given
        List<User> users = List.of(
                new User("A", 20, 10, "X"),
                new User("B", 30, 30, "X"),
                new User("C", 50, 100, "X")
        );

        // when
        double result = stats.averagePostsBelow40(users);

        // then
        assertEquals(20.0, result);
    }

    @Test
    void testNoUsersAbove40() {
        List<User> users = List.of(
                new User("A", 20, 10, "X"),
                new User("B", 30, 20, "X")
        );

        double result = stats.averagePostsAbove40(users);

        assertEquals(0.0, result);
    }

    @Test
    void testNoUsersBelow40() {
        List<User> users = List.of(
                new User("A", 50, 10, "X"),
                new User("B", 60, 20, "X")
        );

        double result = stats.averagePostsBelow40(users);

        assertEquals(0.0, result);
    }

    @Test
    void testEmptyList() {
        List<User> users = List.of();

        double above = stats.averagePostsAbove40(users);
        double below = stats.averagePostsBelow40(users);

        assertEquals(0.0, above);
        assertEquals(0.0, below);
    }

    @Test
    void testSingleUser() {
        List<User> users = List.of(
                new User("A", 45, 10, "X")
        );

        double result = stats.averagePostsAbove40(users);

        assertEquals(10.0, result);
    }
}