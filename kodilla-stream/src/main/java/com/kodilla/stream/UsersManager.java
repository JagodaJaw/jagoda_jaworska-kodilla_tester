package com.kodilla.stream;

import java.util.List;

public class UsersManager {

    public static List<User> filterUsersOlderThan(int age) {
        return UsersRepository.getUsersList().stream()
                .filter(user -> user.getAge() > age)
                .toList();
    }

    public static List<String> filterChemistGroupUsernames() {
        return UsersRepository.getUsersList().stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .map(User::getUsername)
                .toList();
    }

    public static List<String> filterActiveChemistsUsernames(int minPosts) {
        return UsersRepository.getUsersList().stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .filter(user -> user.getNumberOfPost() > minPosts)
                .map(User::getUsername)
                .toList();
    }

    public static List<String> filterUsernamesWithPostsAtLeast(int minPosts) {
        return UsersRepository.getUsersList().stream()
                .filter(user -> user.getNumberOfPost() >= minPosts)
                .sorted((u1, u2) -> Integer.compare(u2.getNumberOfPost(), u1.getNumberOfPost()))
                .map(User::getUsername)
                .toList();
    }
}
