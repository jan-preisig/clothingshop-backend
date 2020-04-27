package com.netcetera.clothingshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "picture")
public class Picture extends BaseEntity {

    /**
     * Creates the field 'name' on the database.
     */
    @Column(name = "name", nullable = false, unique = false)
    private String name;

    /**
     * Creates the field 'image' on the database.
     */
    @Column(name = "imageURL", nullable = true, unique = false)
    private String imageURL;

    /**
     * Links this picture to a location.
     */
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    private Item item;
}
