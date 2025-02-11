package com.mftplus.spring05practice.person;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "userEntity")
@Table(name = "user_tbl")
public class User implements UserDetails {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    private boolean accountNonExpire;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

//    @Column(name = "locked")
//    private boolean locked;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "user_role_tbl",
//            joinColumns = @JoinColumn(name = "username"),
//            inverseJoinColumns = @JoinColumn(name = "role_name"),
//            foreignKey = @ForeignKey(name = "fk_user_role"),
//            inverseForeignKey = @ForeignKey(name = "fk_inverse_user_role")
//    )

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Role> roleSet;

    public void addRole(Role role){
        if(roleSet == null){
            roleSet = new HashSet<>();
        }
        roleSet.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(roleSet.toArray(new GrantedAuthority[roleSet.size()]));
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
//    }
}
