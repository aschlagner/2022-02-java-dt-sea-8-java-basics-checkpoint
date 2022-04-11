package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Comparator<E> comparator = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                if (descending == true) {
                    if (o1.expiryDate().isBefore(o2.expiryDate())) {
                        return 1;
                    } else if (o1.expiryDate().isAfter(o2.expiryDate())) {
                        return -1;
                    } else {
                    return 0;
                    }
                } else {
                    if (o1.expiryDate().isBefore(o2.expiryDate())) {
                        return -1;
                    } else if (o1.expiryDate().isAfter(o2.expiryDate())) {
                        return 1;
                    } else {
                    return 0;
                    }
                }
            }
        };
        Collections.sort(listOfExpireables, comparator);
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
