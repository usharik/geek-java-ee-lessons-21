package ru.geekbrains.service;

import ru.geekbrains.persist.ToDoCategory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class ToDoRepr implements Serializable {

    private Long id;

    @NotEmpty
    private String description;

    @NotNull
    private LocalDate targetDate;

    private Long categoryId;

    private String categoryName;

    public ToDoRepr() {
    }

    public ToDoRepr(Long id, String description, LocalDate targetDate, ToDoCategory toDoCategory) {
        this.id = id;
        this.description = description;
        this.targetDate = targetDate;
        this.categoryId = toDoCategory != null ? toDoCategory.getId() : null;
        this.categoryName = toDoCategory != null ? toDoCategory.getName() : null;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
