package com.smartquizpro.logic;

import java.util.ArrayList;

import com.smartquizpro.models.User;


public class AuthManager {

    private static ArrayList<User> users = new ArrayList<>();

    static {

        users.add(new User("teacher", "123", "Teacher"));
        users.add(new User("student", "123", "Student"));

    }

    public User login(String username, String password) {

        for (User user : users) {

            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }

    public void signup(User user) {

        users.add(user);

    }
}