package com.example.mycode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseEntity {

    private String mainName;

    private String subName;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

}
