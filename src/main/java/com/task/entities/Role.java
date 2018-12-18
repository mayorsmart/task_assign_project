package com.task.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    private String name;

    @ManyToMany(mappedBy = "roles")
   private List<User>users;

    public Role(String name) {

        this.name = name;
    }


}
