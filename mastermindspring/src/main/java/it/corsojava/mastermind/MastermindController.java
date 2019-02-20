package it.corsojava.mastermind;

import it.corsojava.mastermind.controllers.UserController;
import it.corsojava.mastermind.dto.UserDTO;
import it.corsojava.mastermind.javaBean.UserBean;
import it.corsojava.mastermind.repository.Dao;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MastermindController {

    private UserController userController;
    private static final long serialVersionUID=1L;

     @RequestMapping("/")
    public String getMessage() {
                return "index";
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

    @GetMapping("/showViewPage")
    public String passParametersWithModel(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("spring", "mvc");
        model.addAttribute("message", "Baeldung");
        model.mergeAttributes(map);
        return "viewPage";
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
