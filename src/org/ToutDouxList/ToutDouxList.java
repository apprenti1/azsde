package org.ToutDouxList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ToutDouxList {
    private Item[] items = new Item[10];
    int itemCount = 0;
    User user;
    public void add(Item item) {
        if (user.isValid()) {
            if (itemCount<10){
                if (itemCount == 0 || LocalDateTime.now().isAfter(items[itemCount - 1].getCreationDate().plusMinutes(30))) {
                    items[itemCount] = item;
                    itemCount++;
                }
                else {
                    throw new IllegalArgumentException("un utilisateur ne peut pas ajouter deux items dans moins de 30 minutes");
                }
            }
            else {
                throw new ArrayStoreException("un utilisateur ne peut pas stocker plus de 10 items dans une ToutDouxList");
            }
        }
        else {
            throw new IllegalArgumentException("l'utilisateur n'est pas valide");
        }
        
    }
}




