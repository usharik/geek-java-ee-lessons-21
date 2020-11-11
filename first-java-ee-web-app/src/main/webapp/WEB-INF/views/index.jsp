<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="header" value="ToDo list application"/>
</jsp:include>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">ToDo</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">List</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <a class="btn btn-primary" href="todo.html">Add Todo</a>
        </div>

        <div class="col-12">
            <table class="table table-bordered my-2">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Description</th>
                    <th scope="col">User</th>
                    <th scope="col">Target date</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>


                <c:forEach var="todo" items="${requestScope.todos}">
<%--                <% for (ToDo todo : (List<ToDo>) request.getAttribute("todos")) { %>--%>

                <tr>
                    <th scope="row">
                        <c:out value="${todo.id}"/>
<%--                        <%= todo.getId() %>--%>
                    </th>
                    <td>
                        <c:out value="${todo.description}"/>
<%--                        <%= todo.getDescription() %>--%>
                    </td>
                    <td>
                        Cristina
                    </td>
                    <td>
                        <c:out value="${todo.targetDate}"/>
<%--                        <%= todo.getTargetDate() %>--%>
                    </td>
                    <td>
                        <c:url value="/todo" var="todoUrl">
                            <c:param name="id" value="${todo.id}"/>
                        </c:url>
                        <a class="btn btn-success" href="${todoUrl}"><i class="fas fa-edit"></i></a>
                        <a class="btn btn-danger" href="#"><i class="far fa-trash-alt"></i></a>
                    </td>
                </tr>

<%--                <% } %>--%>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="footer_scripts.jsp"%>

</body>
</html>
