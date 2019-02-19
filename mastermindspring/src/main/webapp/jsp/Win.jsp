<html>
<h1>MasterMindWeb</h1>
<h1>We have a winner! <%out.print(request.getAttribute("Username"));%></h1>
<h3>Combinazione di base: <%
out.print(request.getAttribute("combinazione"));
%></h3>
<h3>Combinazione di inserita: <%
out.print(request.getAttribute("valinseriti"));
%></h3>
<body>
    <form action= "<%=request.getContextPath()%>" method="get">
        <br>
        <button type="submit" name="rigioca">rigioca</button>
    </form>
</body>
</html>
