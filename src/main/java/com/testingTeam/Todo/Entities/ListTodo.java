package com.testingTeam.Todo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "list_todo")
public class ListTodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    private String updateDate;

    private int version;

    @Lob
    @Column(name = "attach")
    byte [] attach;

    @ManyToOne
    @JsonIgnore
    private Course course;

    @ManyToOne
    @JsonIgnore
    private Lecture lecture;

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private Status status;

}
