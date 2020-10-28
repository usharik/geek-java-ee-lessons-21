package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    "/something"          /something

    "/something/*"        /something/first
                          /something/second
                          /something/.../.../...asdd

    "*.jpeg"              /aaa.jpeg
                          /dasdasd/bbb.jpeg

    ""                    /

    "/"                   все URL приложения

    "/*"                  не рекомендуется использовать для сервлетов
 */

@WebServlet(urlPatterns = "/first_http_servlet/*")
public class FirstHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Some-Header", "Some value");

        getServletContext().getRequestDispatcher("/page_header").include(req, resp);

        resp.getWriter().println("<h1>Привет от сервлета!</h1>");
        resp.getWriter().println("<p>contextPath: " + req.getContextPath() + "</p>");
        resp.getWriter().println("<p>servletPath: " + req.getServletPath() + "</p>");
        resp.getWriter().println("<p>pathInfo: " + req.getPathInfo() + "</p>");
        resp.getWriter().println("<p>queryString: " + req.getQueryString() + "</p>");
        resp.getWriter().println("<p>param1: " + req.getParameter("param1") + "</p>");
        resp.getWriter().println("<p>param2: " + req.getParameter("param2") + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
