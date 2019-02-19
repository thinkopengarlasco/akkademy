<html>
<h1>MasterMindWeb</h1>
<h1>Inserisci 3 numeri da 0 a 9</h1>
<body>
    <form action= "<%=request.getContextPath()+"/Master"%>" method="get">
        <label for="Uno">Uno</label>
        <input type="number" name="Uno" min="0" max="9" step="1">
        <br>
        <label for="Due">Due</label>
        <input type="number" name="Due" min="0" max="9" step="1">
        <br>
        <label for="Tre">Tre</label>
        <input type="number" name="Tre" min="0" max="9" step="1">
        <br>
        <button type="submit" name="invia">invia</button>
    </form>
    <form action= "<%=request.getContextPath()+"/classifica"%>" method="get">
            <br>
            <button type="submit" name="classifica">classifica</button>
    </form>
</body>
</html>
