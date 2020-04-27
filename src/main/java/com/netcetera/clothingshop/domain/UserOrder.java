package com.netcetera.clothingshop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user_order")
public class UserOrder extends BaseEntity{

    /**
     * Creates the field 'firstname' on the database.
     */
    @Column(name = "firstname", nullable = false)
    private String firstName;

    /**
     * Creates the field 'firstname' on the database.
     */
    @Column(name = "lastname", nullable = false)
    private String lastName;

    /**
     * Creates the field 'street' on the database.
     */
    @Column(name = "street", nullable = false)
    private String street;

    /**
     * Creates the field 'plz' on the database.
     */
    @Column(name = "plz", nullable = false)
    private String plz;

    /**
     * Creates the field 'phonenumber' on the database.
     */
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    /**
     * Creates the field 'country' on the database.
     */
    @Column(name = "country", nullable = false)
    private String country;

    @ManyToMany
    private List<Item> items;
}
