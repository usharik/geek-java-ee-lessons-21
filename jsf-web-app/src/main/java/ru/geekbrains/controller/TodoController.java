package ru.geekbrains.controller;

import ru.geekbrains.persist.ToDo;
import ru.geekbrains.persist.ToDoCategory;
import ru.geekbrains.persist.ToDoCategoryRepository;
import ru.geekbrains.persist.ToDoRepository;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TodoController implements Serializable {

    @Inject
    private ToDoRepository toDoRepository;

    @Inject
    private ToDoCategoryRepository toDoCategoryRepository;

    private ToDo todo;

    private List<ToDo> todos;

    private List<ToDoCategory> toDoCategories;

    public void preloadData(ComponentSystemEvent componentSystemEvent) {
        this.todos = toDoRepository.findAll();
        this.toDoCategories = toDoCategoryRepository.findAll();
    }

    public List<ToDo> getAllTodos() {
        return todos;
    }

    public ToDo getTodo() {
        return todo;
    }

    public void setTodo(ToDo todo) {
        this.todo = todo;
    }

    public String editTodo(ToDo todo) {
        this.todo = todo;
        return "/todo.xhtml?faces-redirect=true";
    }

    public void deleteTodo(ToDo toDo) {
        toDoRepository.delete(toDo.getId());
    }

    public String saveTodo() {
        if (todo.getId() == null) {
            toDoRepository.insert(todo);
        } else {
            toDoRepository.update(todo);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public String createTodo() {
        this.todo = new ToDo();
        return "/todo.xhtml?faces-redirect=true";
    }

    public List<ToDoCategory> getToDoCategories() {
        return toDoCategories;
    }
}
