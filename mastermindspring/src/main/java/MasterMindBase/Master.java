package MasterMindBase;

import MasterMindBase.Login.Controllo;
import MasterMindBase.Login.Registrazione;
import MasterMindBase.Models.CombinationModel;
import MasterMindBase.Models.TryModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Master")
public class Master extends HttpServlet {

    private static final long serialVersionUID =1L;
    int[] numeri = new int[3];
    boolean result = false;
    String combi, vali, PN, N;
    String Username = "";
    String Password = "";
    int i = 5;
    int n=0;
    boolean b;
    int Uno,Due,Tre;
    CombinationService combination = new CombinationService(numeri);
    Dao dao;
    TryModel tri;
    CombinationModel combimod;
    Controllo contr;
    Registrazione regi;
    public Master() {
        super();
        combination.create();
        dao = new Dao();
        dao.connessione();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(n==0)
        {
            Username = request.getParameter("Username");
            Password = request.getParameter("Password");
            contr = new Controllo(Username, Password);
            b = contr.control();
            if(b == true) {
                n++;
            } else {
                response.sendRedirect("/MMWeb/jsp/Registr.jsp");
                Username = request.getParameter("Username");
                Password = request.getParameter("Password");
                contr = new Controllo(Username, Password);
                b = contr.control();
                if(b == true) {
                    regi = new Registrazione(Username, Password);
                    dao.Insert(regi);
                    n++;
                }
                else
                    //response.sendRedirect("/MMWeb/jsp/Error.jsp");
                    request.getRequestDispatcher("/jsp/Error.jsp").include(request, response);
            }
        } else {
            //response.sendRedirect("/MMWeb/jsp/validator.jsp");
            request.getRequestDispatcher("/jsp/validator.jsp").include(request, response);
            try {
                Uno = Integer.parseInt(request.getParameter("Uno"));
                Due = Integer.parseInt(request.getParameter("Due"));
                Tre = Integer.parseInt(request.getParameter("Tre"));
            } catch(NumberFormatException e) {
                e.fillInStackTrace();
            }
            numeri[0] = Uno;
            numeri[1] = Due;
            numeri[2] = Tre;

            combination.check();

            result = combination.getresult();
            combi = combination.getCombinazione();
            vali = combination.getValinseriti();
            PN = combination.getPn();
            N = combination.getN();

            tri = new TryModel(Username, combi, vali, PN, N, result);
            dao.Insert(tri);
            combimod = new CombinationModel(combi);
            dao.Insert(combimod);


            request.setAttribute("Username", Username);
            request.setAttribute("pn", PN);
            request.setAttribute("n", N);
            request.setAttribute("combinazione", combi);
            request.setAttribute("valinseriti", vali);

            if (result == true && i > 1) {
                request.getServletContext().getRequestDispatcher("/jsp/Win.jsp").forward(request, response);
                i = 5;
                combination.create();
                Username = "";
                n=0;
            } else if (result == false && i > 1) {
                i--;
                String tentativi = Integer.toString(i);
                request.setAttribute("tentativi", tentativi);
                request.getRequestDispatcher("/jsp/Lost.jsp").include(request, response);
            } else {
                response.sendRedirect("/MMWeb/jsp/Lostt.jsp");
                i = 5;
                combination.create();
                Username = "";
                n= 0;
            }
            combination.azzeravalori();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}