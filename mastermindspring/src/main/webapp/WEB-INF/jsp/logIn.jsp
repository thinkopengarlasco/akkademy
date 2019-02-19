<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
Autenticazione:
<br><br>
<form action="<%=request.getContextPath()+"/LogIn" %>" method="get">
    <label for="userId">Username</label>
    <input type="text" name="userId" value="">
    <br><br>
    <label for="passwd">Password </label>
    <input type="password" name="passwd" value="">
    <br><br>
    <button type="submit" name="accedi" value="accedi">Accedi</button>
    <br>
    <br>
    <button type="submit" name="registrati" value="registrati">Registrati</button>
</form>
</body>