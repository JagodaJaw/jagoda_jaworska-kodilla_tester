package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import com.kodilla.stream.UsersRepository;
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
    void testEmptyListForUsersAbove40() {
        List<User> users = List.of();

        double result = stats.averagePostsAbove40(users);

        assertEquals(0.0, result);
    }

    @Test
    void testEmptyListForUsersBelow40() {
        List<User> users = List.of();

        double result = stats.averagePostsBelow40(users);

        assertEquals(0.0, result);
    }

    @Test
    void testAverageIncludesUserWithZeroPosts() {
        List<User> users = List.of(
                new User("A", 45, 0, "X"),
                new User("B", 50, 10, "X")
        );

        double result = stats.averagePostsAbove40(users);

        assertEquals(5.0, result);
    }

    @Test
    void testSingleUser() {
        List<User> users = List.of(
                new User("A", 45, 10, "X")
        );

        double result = stats.averagePostsAbove40(users);

        assertEquals(10.0, result);
    }

    @Test
    void testBoundaryAge40() {
        // given
        List<User> users = List.of(
                new User("A", 40, 100, "X"),
                new User("B", 39, 10, "X")
        );

        // when
        double aboveOrEqual40 = stats.averagePostsAbove40(users);
        double below40 = stats.averagePostsBelow40(users);

        // then
        assertEquals(100.0, aboveOrEqual40);
        assertEquals(10.0, below40);
    }

    @Test
    void testAveragesForUsersRepositoryData() {
        // given
        List<User> users = UsersRepository.getUsersList();

        // when
        double aboveOrEqual40 = stats.averagePostsAbove40(users);
        double below40 = stats.averagePostsBelow40(users);

        // then
        assertEquals(2.25, aboveOrEqual40);
        assertEquals(2382.0, below40);
    }
}
