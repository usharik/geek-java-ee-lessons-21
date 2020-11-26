package ru.geekbrains.service;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Stateful
public class CartService implements Serializable {

    public List<ToDoRepr> getAll() {
        return Collections.emptyList();
    }

    public void add(ToDoRepr todo) {

    }
}
