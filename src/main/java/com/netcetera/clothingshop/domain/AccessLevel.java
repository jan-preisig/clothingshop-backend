package com.netcetera.clothingshop.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "access_level")
class AccessLevel extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

}
