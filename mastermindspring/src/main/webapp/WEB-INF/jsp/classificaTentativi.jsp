<%@ page import="java.util.ArrayList" %>
<%@ page import="it.DTO.UserDTO" %>
<%@ page import="it.DTO.TentativoDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    ArrayList<TentativoDTO> list = (ArrayList<TentativoDTO>) request.getSession().getAttribute("classificaTentativi");
%>
<head>
    <title>ClassificaUser</title>
</head>
<body>
Classifica Tentativi:
<br><br>


<table> <!– Inizia la tabella –>
    <table border=”1″>
        <tr> <!– Inizia la prima riga –>
            <td>ID Combinazione</td>
            <!– Prima colonna –>
            <td>N.Tentativo</td>
            <!– Terza colonna –>
            <td>Username</td>
            <!– Seconda colonna –>
            <td>Pos.Esatta</td>
            <!– Terza colonna –>
            <td>Num.Esatto</td>
            <!– Terza colonna –>
            <td>Soluzione</td>
            <!– Terza colonna –>
            <td>Input</td>
            <!– Terza colonna –>
        </tr>
        <!– Fine della prima riga –>
        <%
            for (int i = 0; i < list.size(); i++) {
        %>
        <tr>
            <td><%out.println(list.get(i).getIDComb()); %></td>
            <td><%out.println(list.get(i).getnTentativi()); %></td>
            <td><%out.println(list.get(i).getUser());%></td>
            <td><%out.println(list.get(i).getPosEsatta()); %></td>
            <td><%out.println(list.get(i).getNumEsatto()); %></td>
            <td><%out.println(list.get(i).getSoluzione()); %></td>
            <td><%out.println(list.get(i).getInput()); %></td>
        </tr>
        <% } %>
    </table>
    <!– Fine della tabella –>
</body>
</html>

