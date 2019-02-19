package it.corsojava.mastermind;

import it.corsojava.mastermind.controllers.UserController;
import it.corsojava.mastermind.dto.UserDTO;
import it.corsojava.mastermind.javaBean.UserBean;
import it.corsojava.mastermind.repository.Dao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@RestController
public class MastermindController {

    private UserController userController;
    private static final long serialVersionUID=1L;

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String getMessage() {
        return "ciao";
    }

    @GetMapping
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userController = new UserController();
        Dao dao = new Dao();
        dao.createTableModel();
        //Se utente vuole la classifica
        if(request.getParameterMap().containsKey("Classifica")) {
            mostraClassifica(request,response);
            }
            //se utente vuole giocare
        else {
            setUsername(request, response);
            }
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
        }

        private void setUsername(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
        {
            String username=request.getParameter("username");
            request.getSession().setAttribute("username", username);
            if( userController.addUser(username) )
                response.sendRedirect("Ciclo");
            else {
                request.getRequestDispatcher("paginaErrore").forward(request,response);
                // response.sendRedirect("jsp/paginaErrore.jsp");
            }
        }

        private UserBean calcolaTabellaUtente() {
            UserBean userBean = new UserBean();
            userBean.setUtenti ((ArrayList<UserDTO>) userController.getUsers());
            Collections.sort(userBean.getUtenti());
            return userBean;
        }

        private void mostraClassifica(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException  {

            request.setAttribute("listaUser", calcolaTabellaUtente());
            request.getRequestDispatcher("tabella").forward(request, response);
        }
}
