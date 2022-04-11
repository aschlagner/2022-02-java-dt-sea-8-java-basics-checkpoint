package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.time.LocalDate;

public class DairyProduct implements IExpireable {
    private LocalDate dateProduced;
    private int daysUntilSpoiled;

    public DairyProduct(int daysUntilSpoiled) {
        this.dateProduced = LocalDate.now();
        this.daysUntilSpoiled = daysUntilSpoiled;
    }

    public DairyProduct(LocalDate dateProduced, int daysUntilSpoiled) {
        this.dateProduced = dateProduced;
        this.daysUntilSpoiled = daysUntilSpoiled;
    }

    @Override
    public boolean isExpired() {
        LocalDate now = LocalDate.now();
        LocalDate spoiledDate = this.dateProduced.plusDays(14);
        return (this.dateProduced.isAfter(spoiledDate) || spoiledDate.isBefore(now));
    }

    @Override
    public LocalDate expiryDate() {
        //return this.dateProduced.plusDays(14);
        return this.dateProduced.plusDays(this.daysUntilSpoiled);
    }

    @Override
    public String toString() {
        return String.format("DairyProduct [Date Produced: \"%s\", Expiration Date: \"%s\"]", dateProduced, expiryDate());
    }
    
}
