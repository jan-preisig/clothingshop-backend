package com.netcetera.clothingshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "item")
public class Item extends BaseEntity {

    /**
     * Creates the Field 'name' on the database.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Creates the Field 'price' on the database.
     */
    @Column(name = "price", nullable = false)
    private String price;

    /**
     * Maps all linking pictures to a item.
     */
    @Column(name = "pictures")
    @OneToMany(mappedBy = "item")
    private List<Picture> pictures;

    /**
     * Links this Item to a Category.
     */
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @ManyToMany(mappedBy = "items")
    private List<UserOrder> userOrders;
}
