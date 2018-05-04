package controller;

import domain.Person;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class VeranderStatus extends RequestHandler {

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("userstatus");
        System.out.println(status);
        Person user = (Person)request.getSession().getAttribute("user");
        user.setStatus(status);
    }
}
