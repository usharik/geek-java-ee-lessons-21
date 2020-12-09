package ru.geekbrains;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient(new ClientConfig()
                .register(JacksonJsonProvider.class));

        WebTarget toDoTarget = client.target("http://localhost:8080/jsf-web-app/api/v1/todo/all");

        Invocation.Builder request = toDoTarget.request(MediaType.APPLICATION_JSON);
        Response response = request.get();

        List<ToDoRepr> todos = response.readEntity(new GenericType<List<ToDoRepr>>() {});
        todos.forEach(todo -> System.out.println(todo.getDescription()));
    }
}
