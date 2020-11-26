package ru.geekbrains.service;

import javax.ejb.Remote;
import java.util.List;
import java.util.concurrent.Future;

@Remote
public interface ToDoServiceRemote {

    List<ToDoRepr> findAll();

    Future<ToDoRepr> findByIdAsync(long id);
}
