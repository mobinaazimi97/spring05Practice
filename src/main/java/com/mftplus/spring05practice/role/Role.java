package com.mftplus.spring05practice.role;

import com.mftplus.spring05practice.permission.Permission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "roleEntity")
@Table(name = "role_tbl")
public class Role {
    @Id
    @Column(name = "role_name", length = 30)
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Permission> permissionSet;
}
