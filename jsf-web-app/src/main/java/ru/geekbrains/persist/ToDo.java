package ru.geekbrains.persist;

import java.time.LocalDate;

public class ToDo {

    private Long id;

    private String description;

    private LocalDate targetDate;

    public ToDo() {
    }

    public ToDo(Long id, String description, LocalDate targetDate) {
        this.id = id;
        this.description = description;
        this.targetDate = targetDate;
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
}
