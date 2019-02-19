package MasterMindBase;

import MasterMindBase.DTO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/classifica")
public class Classifica extends HttpServlet {
    public Classifica() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RepositoryTentativi ret = new RepositoryTentativi();
        RepositoryUser reu = new RepositoryUser();
        PrintWriter out = response.getWriter();
        ret.databalist();
        reu.databalist();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.print("<tr><td>ID</td><td>Username</td><td>Punteggio</td></tr>");
        for(UserModel u: reu.databalist()) {
            out.print("<tr><td>"+u.getid()+"</td><td>"+u.getNome()+"</td><td>"+u.punteggio()+"</td></tr>");
        }
        out.print("<tr><td>Username</td><td>Pn</td><td>N</td><td>CombinazioneBase</td><td>CombinazioneInserita</td><td>Risultato</td></tr>");
        for(TentativiModel u: ret.databalist()) {
            out.println("<tr><td>"+u.getUsername()+"</td><td>"+u.getPn()+"</td><td>"+u.getN()+"</td><td>"+u.getCodicebase()+"</td><td>"+u.getCodiceinserito()+"</td><td>"+u.isResult()+"</td></tr>");
        }
        out.println("</body>");
        out.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
