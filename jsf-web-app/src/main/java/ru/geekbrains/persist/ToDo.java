package ru.geekbrains.persist;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDate targetDate;

    @ManyToOne
    private ToDoCategory toDoCategory;

    public ToDo() {
    }

    public ToDo(Long id, String description, LocalDate targetDate, ToDoCategory toDoCategory) {
        this.id = id;
        this.description = description;
        this.targetDate = targetDate;
        this.toDoCategory = toDoCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public ToDoCategory getToDoCategory() {
        return toDoCategory;
    }

    public void setToDoCategory(ToDoCategory toDoCategory) {
        this.toDoCategory = toDoCategory;
    }
}
