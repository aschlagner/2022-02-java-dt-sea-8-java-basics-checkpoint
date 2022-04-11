package com.wildcodeschool.sea8.checkpoint.java_basics;

import java.time.LocalDate;

public class Certificate implements IExpireable {

    // Date to when this certificate is valid
    private LocalDate validTo;
    // Subject of the certificate and issuer of the certificate
    private String subject, issuer;

    public Certificate(String subject, String issuer, LocalDate validTo) {
        this.subject = subject;
        this.issuer = issuer;
        this.validTo = validTo;
    }

    public Certificate(String subject, String issuer, long validityPeriodInDays) {
        this.subject = subject;
        this.issuer = issuer;
        this.validTo = LocalDate.now().plusDays(validityPeriodInDays);
    }

    public void renew(long daysValidFromNow) {
        this.validTo = LocalDate.now().plusDays(daysValidFromNow);
    }

    @Override
    public boolean isExpired() {
        LocalDate now = LocalDate.now();
        LocalDate certDate = this.validTo;
        return (certDate.isAfter(now.plusDays(60)) || certDate.isBefore(now));
    }

    @Override
    public LocalDate expiryDate() {
        return this.validTo;
    }

    @Override
    public String toString() {
        return String.format("Certificate [Subject: \"%s\", Issuer: \"%s\", Valid Until: \"%s\"]", subject, issuer, validTo.toString());
    }
    
}
