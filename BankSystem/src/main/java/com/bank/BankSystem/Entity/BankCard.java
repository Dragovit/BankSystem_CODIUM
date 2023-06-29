package com.bank.BankSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class BankCard {
    @Id
    @GeneratedValue
    private int id;
    private String cardNumber;
    private String expDate;
    private String cardHolder;
    private String cvc;

    public BankCard() {
    }

    public BankCard(int id, String cardNumber, String expDate, String cardHolder, String cvc) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cardHolder = cardHolder;
        this.cvc = cvc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
