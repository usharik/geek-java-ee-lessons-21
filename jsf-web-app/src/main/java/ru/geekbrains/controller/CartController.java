package ru.geekbrains.controller;

import ru.geekbrains.service.CartService;
import ru.geekbrains.service.ToDoRepr;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public void add(ToDoRepr todo) {
        cartService.add(todo);
    }

    public List<ToDoRepr> getAllItems() {
        return cartService.getAll();
    }

    public void delete(ToDoRepr toDoRepr) {
        cartService.delete(toDoRepr.getId());
    }
}
