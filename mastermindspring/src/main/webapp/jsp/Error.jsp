<html>
<h1>MasterMindWeb</h1>
<h1>Loser <%out.print(request.getAttribute("Username"));%></h1>
<h3>Errore account esistente</h3>
<body>
    <form action= "http://localhost:8080/MMWeb/jsp/Registr.jsp">
        <br>
        <button type="submit" name="riprova">riprova</button>
    </form>
</body>
</html>
