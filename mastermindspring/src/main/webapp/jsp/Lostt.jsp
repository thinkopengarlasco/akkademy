<html>
<h1>MasterMindWeb</h1>
<h1>SCARSO <%out.print(request.getAttribute("Username"));%></h1>
<body>
    <form action= "<%=request.getContextPath()%>" method="get">
        <br>
        <button type="submit" name="rigioca">rigioca</button>
    </form>
</body>
</html>
