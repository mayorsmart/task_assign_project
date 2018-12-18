package com.task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty
    private String name;

    @Size(min = 6)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns =  {
            @JoinColumn(name = "USER_EMAIL",referencedColumnName = "email")
    }, inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME",referencedColumnName = "name")})
    private List<Role> roles;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
