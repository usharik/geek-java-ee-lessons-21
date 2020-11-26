package ru.geekbrains;

import ru.geekbrains.service.ToDoRepr;
import ru.geekbrains.service.ToDoServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EjbClient {

    public static void main(String[] args) throws IOException, NamingException, ExecutionException, InterruptedException {
        Context context = createInitialContext();

        ToDoServiceRemote todoService = (ToDoServiceRemote) context.lookup("ejb:/jsf-web-app/ToDoServiceImpl!ru.geekbrains.service.ToDoServiceRemote");

        todoService.findAll()
                .forEach(todo -> System.out.println(todo.getId() + " " + todo.getDescription() + " " + todo.getTargetDate()));

        Future<ToDoRepr> byIdAsync = todoService.findByIdAsync(4);
        System.out.println(byIdAsync.get());
    }

    public static Context createInitialContext() throws IOException, NamingException {
        final Properties env = new Properties();
        env.load(EjbClient.class.getClassLoader().getResourceAsStream("wildfly-jndi.properties"));
        return new InitialContext(env);
    }
}
