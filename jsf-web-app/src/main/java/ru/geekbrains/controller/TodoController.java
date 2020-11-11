package ru.geekbrains.controller;

import ru.geekbrains.persist.ToDo;
import ru.geekbrains.persist.ToDoRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@Named
@SessionScoped
public class TodoController implements Serializable {

    @Inject
    private ToDoRepository toDoRepository;

    private ToDo todo;

    public List<ToDo> getAllTodos() throws SQLException {
        return toDoRepository.findAll();
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

    public void deleteTodo(ToDo toDo) throws SQLException {
        toDoRepository.delete(toDo.getId());
    }

    public String saveTodo() throws SQLException {
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
}
