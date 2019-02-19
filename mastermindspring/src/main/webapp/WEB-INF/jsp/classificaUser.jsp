<%@ page import="java.util.ArrayList" %>
<%@ page import="it.DTO.UserDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    ArrayList<UserDTO> list = (ArrayList<UserDTO>) request.getSession().getAttribute("classificaUser");
%>
<head>
    <title>ClassificaUser</title>
</head>
<body>
Classifica User:
<br><br>
<% int i = 0;%>

<table> <!– Inizia la tabella –>
    <table border=”1″>
        <tr> <!– Inizia la prima riga –>
            <td>ID</td>
            <!– Prima colonna –>
            <td>Username</td>
            <!– Seconda colonna –>
            <td>Punteggio</td>
            <!– Terza colonna –>
        </tr>
        <!– Fine della prima riga –>
        <%
            for (i = 0; i < list.size(); i++) {
        %>
        <tr>
            <td><%out.println(list.get(i).getID()); %></td>
            <td><%out.println(list.get(i).getNome()); %></td>
            <td><%out.println(list.get(i).getPunteggio()); %></td>
        </tr>
        <% } %>
    </table>
    <!– Fine della tabella –>
</body>
</html>

