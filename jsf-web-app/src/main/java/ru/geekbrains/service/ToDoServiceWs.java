package ru.geekbrains.service;

import javax.jws.*;
import java.util.List;

@WebService
public interface ToDoServiceWs {

    @WebMethod
    List<ToDoRepr> findAll();

    @WebMethod
    ToDoRepr findById(long id);

    @WebMethod
    void insert(ToDoRepr toDoRepr);
}
