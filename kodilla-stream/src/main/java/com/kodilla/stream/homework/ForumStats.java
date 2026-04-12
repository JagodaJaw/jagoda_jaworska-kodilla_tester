package com.kodilla.stream.homework;

import com.kodilla.stream.User;

import java.util.List;

public class ForumStats {

    public double averagePostsAbove40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0.0);
    }

    public double averagePostsBelow40(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() < 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0.0);
    }

    public static void main(String[] args) {
        ForumStats stats = new ForumStats();

        List<User> users = com.kodilla.stream.UsersRepository.getUsersList();

        double above40 = stats.averagePostsAbove40(users);
        double below40 = stats.averagePostsBelow40(users);

        System.out.println("Średnia postów (>=40): " + above40);
        System.out.println("Średnia postów (<40): " + below40);
    }
}
