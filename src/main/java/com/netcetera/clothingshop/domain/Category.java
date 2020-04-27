package com.netcetera.clothingshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "category")
public class Category extends BaseEntity {

    /**
     * Creates the Field 'name' on the database.
     */
    @Column(name = "name")
    private String name;

    /**
     * Maps all linking items to a category.
     */
    @Column(name = "items")
    @OneToMany(mappedBy = "category")
    private List<Item> items;
}
