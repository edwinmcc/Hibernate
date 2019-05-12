package edu.java.hibernate.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by egnanasigamony on 29/05/2017.
 */

/*
@Entity
@Table(name="Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    @Column(name = "name",nullable = false,unique = true)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parentId")
    private Category parentCategory;
    @OneToMany(targetEntity = edu.java.hibernate.model.Category.class, mappedBy = "parentId")
    private Set<Category> subCategories;


    public Category() {
        subCategories = new LinkedHashSet<>();
    }

    public Category(String name) {
        this();
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory=parentCategory;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }





}
*/
