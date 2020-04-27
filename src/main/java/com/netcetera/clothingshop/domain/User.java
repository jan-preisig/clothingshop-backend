package com.netcetera.clothingshop.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User visiting Ravintola (DMO,NSC,MSW,RM,CSH ...).
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User extends BaseEntity implements UserDetails {

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToOne
    @JoinColumn(name = "access_level_id", referencedColumnName = "id", nullable = false)
    private AccessLevel accessLevel;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        if ("ADMIN".equals(accessLevel.getName())) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isDeleted() {
        return false;
    }

}
