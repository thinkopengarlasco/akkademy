<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
    <h1>Benvenuto su Master Mind!</h1>
</head>
<body>
<form action="<%=request.getContextPath()+"/Start" %>" method="get">
    <br>
    Cosa si vuole fare?
    <select name="scelta">
        <option name="MasterMind" value="MasterMind">Giocare a MasterMind</option>
        <option name="Classifica User" value="Classifica User">Classifica User</option>
        <option name="Classifica Tentativi" value="Classifica Tentativi">Classifica Tentativi</option>
    </select>
    <br><br>
    <button type="submit" name="invia">Invia</button>
</form>

</body>
</html>
