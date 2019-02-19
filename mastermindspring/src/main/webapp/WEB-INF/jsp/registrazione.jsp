<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Registrazione effettuata!!
<br><br>
<form action="<%=request.getContextPath()+"/Start" %>" method="get">
    <button type="submit" name="accedi" value="accedi">Accedi</button>
</form>
</body>
</html>
