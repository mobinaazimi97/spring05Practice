package com.mftplus.spring05practice.person;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name="permissionEntity")
@Table(name="permission_table")
public class Permission {

    @Id
//    @SequenceGenerator(name = "permissionSeq", sequenceName = "permission_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissionSeq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permissionName",length = 100)
    private String permissionName;
}
