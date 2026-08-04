package com.portfolio.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.portfolio.model.User;

public class UserTest {

    @Test
    void testUserCreation() {

        User user = new User(
                101,
                "Poornima",
                "poornima@gmail.com"
        );

        assertEquals(101, user.getUserId());
        assertEquals("Poornima", user.getUserName());
        assertEquals("poornima@gmail.com", user.getEmail());
    }

    @Test
    void testUserEmail() {

        User user = new User();

        user.setEmail("test@gmail.com");

        assertEquals("test@gmail.com", user.getEmail());
    }
}
