package org.ToutDouxList.test;

import org.ToutDouxList.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    public void setup() {
        user = new User("aitboukha", "elias", "elias.aitboukha@gmail.com", "aaA34dqddssd", LocalDate.now().minusYears(20));
    }

    @Test
    void isValid() {
        setup();
        assertTrue(user.isValid());
    }

    @Test
    void isValidWithInvalidEmail() {
        setup();
        user.setEmail("elias.aitboukha");
        assertFalse(user.isValid());
    }

    @Test
    void isValidWithEmptyName() {
        setup();
        user.setPrenom("");
        assertFalse(user.isValid());
    }

    @Test
    void isValidWithEmptyFirstName() {
        setup();
        user.setPrenom("");
        assertFalse(user.isValid());
    }

    @Test
    void isValidWithUnderAge() {
        setup();
        user.setDateNaissance(LocalDate.now().minusYears(10));
        assertFalse(user.isValid());
    }

    @Test
    void calculateAgeFromBirthDate() {
        setup();
        assertEquals(20, user.calculateAgeFromBirthDate());
    }
}

