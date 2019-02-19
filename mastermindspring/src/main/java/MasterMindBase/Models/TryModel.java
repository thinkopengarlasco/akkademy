package MasterMindBase.Models;

public class TryModel {
    String username;
    String combinazione;
    String valinseriti;
    String pn;
    String n;
    boolean result;
    public TryModel(String username, String combinazione, String valinseriti, String pn, String n, boolean result) {
        this.username = username;
        this.combinazione = combinazione;
        this.valinseriti = valinseriti;
        this.pn = pn;
        this.n = n;
        this.result = result;
    }
    public String setSql() {
        String sql = "INSERT INTO Prova(Username, CodiceBase, CodiceInserito, PosizioniTrovate, NumeriTrovati, Risultato) VALUES('" + username + "','" + combinazione + "','" + valinseriti + "','" + pn + "','" + n + "', '" + result + "')";
        return sql;
    }
}
