package com.task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String date;

    @NotEmpty
    private String startTime;

    @NotEmpty
    private String stopTime;

    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    public Task(String date, String startTime, String stopTime, String description, User user) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
        this.user = user;
    }

    public Task(String date, String startTime, String stopTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }
}
