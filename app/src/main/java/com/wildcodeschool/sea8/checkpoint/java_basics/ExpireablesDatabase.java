package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.util.ArrayList;
import java.util.List;

public class ExpireablesDatabase<E extends IExpireable> {
    private List<E> listOfExpireables = new ArrayList<>();

    public void addItem(E item) {
        listOfExpireables.add(item);
    }

    public void removeExpired() {
        for (E item : listOfExpireables) {
            if (item.isExpired()) {
                listOfExpireables.remove(item);
            }
        }
    }

    public void sortByExpirationDate(boolean descending) {
        // TODO: sort the list by the expiration date of it's entries
        // hint: use a comparator and expiryDate()
        
    }

    public E getFirstEntry() {
        return listOfExpireables.get(0);
    }

    public E getLastEntry() {
        return listOfExpireables.get(listOfExpireables.size()-1);
    }

    public List<E> getList() {
        return listOfExpireables;
    }

}
