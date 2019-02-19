<html>
<h1>MasterMindWeb</h1>
<h1>Loser <%out.print(request.getAttribute("Username"));%></h1>
<h3>Posizione e numero giusti: <%
out.print(request.getAttribute("pn"));
%></h3>
<h3>Numero giusto, posizione sbagliata: <%
out.print(request.getAttribute("n"));
%></h3>
<h3>Combinazione di base: <%
out.print(request.getAttribute("combinazione"));
%></h3>
<h3>Combinazione di inserita: <%
out.print(request.getAttribute("valinseriti"));
%></h3>
<h2>Hai altri <%
out.print(request.getAttribute("tentativi"));
%> tentativi</h2>
<body>
    <form action= "http://localhost:8080/MMWeb/jsp/validator.jsp">
        <br>
        <button type="submit" name="riprova">riprova</button>
    </form>
</body>
</html>
