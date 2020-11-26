package ru.geekbrains.persist;

import ru.geekbrains.service.ToDoRepr;

import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import java.util.List;

@Local
public interface ToDoRepository {

    void insert(ToDo toDo);

    void update(ToDo toDo);

    void delete(long id);

    ToDo findById(long id);

    List<ToDo> findAll();

    ToDoRepr findToDoReprById(long id);

    List<ToDoRepr> findAllToDoRepr();
}
