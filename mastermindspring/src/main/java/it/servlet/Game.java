package it.servlet;

import it.Context;
import it.controllers.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/Game")
public class Game extends HttpServlet {
    private Controller controller;
    private int nTentativi = 1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        controllGame(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sceltaProseguo(request, response);
    }

    private void controllGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        //this.controller = Context.getInstance().getController();
        //this.controller.registraLog("nzr", "242dn");
        String combination = request.getParameter("numero1");
        combination += "," + request.getParameter("numero2");
        combination += "," + request.getParameter("numero3");
        //System.out.println("La combination è: "+combination);
        if (Ciclo.contatore == 4) { //=4 se nel ciclo il contatore è impostato a 5
            this.controller = Context.getInstance().getController();
            this.controller.setUsername(username);
            this.controller.creaCombinazione();
            request.getSession().setAttribute("soluzione", Arrays.toString(this.controller.getSoluzione()));
            System.out.println(request.getAttribute("soluzione"));
        }
        this.controller.verificaInput(combination);
        this.controller.verificaCombinazione();
        this.controller.salvaGiocata(this.nTentativi);
        this.nTentativi++;
        request.setAttribute("PosEsa", this.controller.getEsito()[0]);
        request.setAttribute("PosErr", this.controller.getEsito()[1]);
        request.setAttribute("input", Arrays.toString(this.controller.getInput()));
        if (this.controller.getEsito()[0] < 3) {
            request.getRequestDispatcher("jsp/result.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("jsp/vittoria.jsp").include(request, response);
        }
    }

    private void sceltaProseguo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("scelta").equals("SI")) {
            response.sendRedirect("Ciclo");
        } else if (request.getParameter("scelta").equals("NO")) {
            request.getRequestDispatcher("jsp/saluti.jsp").include(request, response);
        }
    }

}
