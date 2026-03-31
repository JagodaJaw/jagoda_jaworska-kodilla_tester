package com.kodilla.stream;

import java.util.List;

public class UsersManager {

    private List<User> users;

    public UsersManager(List<User> users) {
        this.users = users;
    }

    public List<User> filterUsersOlderThan(int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .toList();
    }

    public List<String> filterChemistGroupUsernames() {
        return users.stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .map(User::getUsername)
                .toList();
    }

    public List<String> filterActiveChemistsUsernames(int minPosts) {
        return users.stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .filter(user -> user.getNumberOfPost() > minPosts)
                .map(User::getUsername)
                .toList();
    }
}