package com.deepak.kamboj.MoneyManager.model;

import jakarta.persistence.Entity;

@Entity
public class Expense extends BaseModel {
    private String date;
    private String note;
    private String description;
}
