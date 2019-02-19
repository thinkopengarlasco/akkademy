<html>
<h1>MasterMindWeb</h1>
<h1>LogIn</h1>
<body>
    <form action= "<%=request.getContextPath()+"/Master"%>" method="get">
        <label for="Username">Username</label>
        <input type="text" name ="Username" value="">
        <br>
        <label for="Password">Password</label>
        <input type="text" name ="Password" value="">
        <br>
        <button type="submit" name="invia">invia</button>
    </form>
</body>
</html>
