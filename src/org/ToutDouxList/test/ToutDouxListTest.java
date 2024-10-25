package org.ToutDouxList.test;

import org.ToutDouxList.User;
import org.junit.jupiter.api.Test;
import org.ToutDouxList.ToutDouxList;
import org.ToutDouxList.Item;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ToutDouxListTest {

    User user;

    public void setup() {
        user = new User("aitboukha", "elias", "elias.aitboukha@gmail.com", "aaA34dqddssd", LocalDate.now().minusYears(20));
        user.setToutDouxList(new ToutDouxList());
    }

    @Test
    void add() {
        setup();
        user.getToutDouxList().add(new Item("test", "test"));
        assertEquals(1, user.getToutDouxList().getItemCount());
    }

    @Test
    void addMoreThanTenItems() {
        setup();
        for (int i = 0; i < 15; i++) {
            System.out.println("test "+i);
            if (i<10){
                assertDoesNotThrow(() -> user.getToutDouxList().add(new Item("test", "test")));
                //user.getToutDouxList().add(new Item("test", "test"));
                user.getToutDouxList().getItems()[user.getToutDouxList().getItemCount()-1].setCreationDate(LocalDateTime.now().minusDays(15-i));
            }
            else {
                assertThrows(ArrayStoreException.class, () -> user.getToutDouxList().add(new Item("test", "test")));
                //user.getToutDouxList().add(new Item("test", "test"));
                user.getToutDouxList().getItems()[user.getToutDouxList().getItemCount()-1].setCreationDate(LocalDateTime.now().minusDays(15-i));
            }
        }
        assertEquals(10, user.getToutDouxList().getItemCount());
    }

    @Test
    void addTwoItemsInLessThan30Minutes() {
        setup();
        user.getToutDouxList().add(new Item("test", "test"));
        assertThrows(IllegalArgumentException.class, () -> user.getToutDouxList().add(new Item("test2", "test2")));
    }

    @Test
    void addWithInvalidUser() {
        setup();
        user.setDateNaissance(LocalDate.now().minusYears(10));
        assertThrows(IllegalArgumentException.class, () -> user.getToutDouxList().add(new Item("test", "test")));
    }
}

