package ru.geekbrains.service;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateful
public class CartService implements Serializable {

    private final Map<Long, ToDoRepr> toDoReprMap = new HashMap<>();

    public List<ToDoRepr> getAll() {
        return new ArrayList<>(toDoReprMap.values());
    }

    public void add(ToDoRepr todo) {
        toDoReprMap.put(todo.getId(), todo);
    }

    public void delete(Long id) {
        toDoReprMap.remove(id);
    }
}
