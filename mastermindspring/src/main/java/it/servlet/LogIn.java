package it.servlet;

import it.Context;
import it.controllers.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
    private Controller controller;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("Registrati= "+request.getParameterMap().containsKey("registrati"));
        //System.out.println("Accedi= "+request.getParameterMap().containsKey("accedi"));
        if (request.getParameterMap().containsKey("registrati")) {
            this.registrati(request, response);
        } else if (request.getParameterMap().containsKey("accedi")) {
            this.controllo(request, response);
        }
    }

    protected void controllo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.controller = Context.getInstance().getController();
        String username = request.getParameter("userId");
        String passwd = request.getParameter("passwd");
        if (this.controller.controlloUtente(username, passwd)) {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("passwd", passwd);
            response.sendRedirect("Ciclo");
        } else {
            request.getSession().setAttribute("errore", "Username o password sbagliata!");
            request.getRequestDispatcher("jsp/error.jsp").include(request, response);
        }
    }

    protected void registrati(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.controller = Context.getInstance().getController();
        String username = request.getParameter("userId");
        String passwd = request.getParameter("passwd");
        if (this.controller.registraLog(username, passwd)) {
            request.getRequestDispatcher("jsp/registrazione.jsp").include(request, response);
        } else {
            System.out.println("Registrazione fallita!!");
        }
    }


}
