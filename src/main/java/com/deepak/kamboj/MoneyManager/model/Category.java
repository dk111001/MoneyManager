package com.deepak.kamboj.MoneyManager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "parent_id"})})
public class Category extends BaseModel {
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

//    @OneToMany(mappedBy = "parent")
//    @JsonManagedReference
//    private List<Category> children;
}
