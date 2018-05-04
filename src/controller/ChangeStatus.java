package controller;

import controller.JsonWriter;
import controller.RequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.RequestHandler;
import domain.Person;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeStatus extends RequestHandler {


    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = (Person)request.getSession().getAttribute("user");
        String status = person.getStatus();
        JsonWriter.createResult(request,response,"{ \"status\":\"" + status + "\"}" );
    }
}
