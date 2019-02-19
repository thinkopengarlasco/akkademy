package it.servlet;

import it.Context;
import it.controllers.ControllerClassifiche;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Classifica")
public class Classifica extends HttpServlet {
    private ControllerClassifiche controllerClassifiche;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.controllerClassifiche = Context.getInstance().getControllerClassifiche();
        if (request.getSession().getAttribute("scelta").equals("Classifica User")) {
            request.getSession().setAttribute("classificaUser", this.controllerClassifiche.classificaUser());
            request.getRequestDispatcher("jsp/classificaUser.jsp").include(request, response);
        } else if (request.getSession().getAttribute("scelta").equals("Classifica Tentativi")) {
            request.getSession().setAttribute("classificaTentativi", this.controllerClassifiche.classificaTentativi());
            request.getRequestDispatcher("jsp/classificaTentativi.jsp").include(request, response);
        } else {
            response.sendRedirect("Start"); //nel caso sbaglio
        }
    }
}
