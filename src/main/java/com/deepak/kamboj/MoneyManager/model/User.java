package com.deepak.kamboj.MoneyManager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    private String userName;
    private String password;
    private boolean active;
    private String roles;

}
