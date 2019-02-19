<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getSession().getAttribute("errore")%>
<br><br>
<form action="<%=request.getContextPath()+"/LogIn" %>" method="get">
    <label for="userId">Username</label>
    <input type="text" name="userId" value="">
    <br><br>
    <label for="passwd">Password </label>
    <input type="password" name="passwd" value="">
    <br><br>
    <button type="submit" name="accedi">Accedi</button>
</form>
</body>
</html>
