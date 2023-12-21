package com.deepak.kamboj.MoneyManager.model;

import com.fasterxml.jackson.databind.ser.Serializers;

public class Account extends Serializers.Base {
    private AccountType type;
    private String name;
    private String description;
    private Long money;
}
