package it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Start")
public class ServletStart extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = request.getParameter("scelta");
        request.getSession().setAttribute("scelta", scelta);
        scelta(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("scelta", "MasterMind");
        doGet(request, response);
    }

    private void scelta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scelta = (String) request.getSession().getAttribute("scelta");
        if (scelta.equals("MasterMind")) {
            request.getRequestDispatcher("jsp/logIn.jsp").include(request, response);
            //System.out.println("Sono in master");
            //String username=request.getParameter("username");
            //request.getSession().setAttribute("username", username);
            //response.sendRedirect("Ciclo");
        } else {
            //System.out.println("Sono in classifica");
            String username = request.getParameter("username");
            response.sendRedirect("Classifica");
        }
    }
}

