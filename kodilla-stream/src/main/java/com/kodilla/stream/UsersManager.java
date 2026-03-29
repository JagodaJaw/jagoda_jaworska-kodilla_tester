package com.kodilla.stream;

import java.util.List;
import java.util.stream.Collectors;

public class UsersManager {

    public static List<String> filterChemistGroupUsernames() {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> "Chemists".equals(user.getGroup()))
                .map(User::getUsername)
                .collect(Collectors.toList());
    }

    public static List<User> filterUsersOlderThan(int age) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public static List<User> filterUsersWithManyPosts(int minPosts) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getNumberOfPost() > minPosts) // albo getNumberOfPosts()
                .collect(Collectors.toList());
    }
    public static List<String> filterActiveChemistsUsernames(int minPosts) {
        return UsersRepository.getUsersList()
                .stream()
                .filter(user -> "Chemists".equals(user.getGroup()))
                .filter(user -> user.getNumberOfPost() > minPosts)
                .map(User::getUsername)
                .collect(Collectors.toList());
    }
}