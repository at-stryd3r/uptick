package com.uptik.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="auth_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_user_id")
    private int id;

    @Column(name = "first_name")
    private int name;

    @Column(name = "last_name")
    private int lastName;

    @Column(name = "email")
    private int email;

    @Column(name = "password")
    private int password;

    @Column(name = "status")
    private int status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name="auth_user_role"), inverseJoinColumns = @JoinColumn(name ="auth_user_id" ))
    private Set<Role> roles;

}
