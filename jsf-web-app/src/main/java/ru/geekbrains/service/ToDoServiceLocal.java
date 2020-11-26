package ru.geekbrains.service;

import javax.ejb.Local;
import java.util.List;
import java.util.concurrent.Future;

@Local
public interface ToDoServiceLocal {

    void insert(ToDoRepr toDoRepr);

    void update(ToDoRepr toDoRepr);

    void delete(long id);

    ToDoRepr findById(long id);

    List<ToDoRepr> findAll();

    Future<ToDoRepr> findByIdAsync(long id);
}
