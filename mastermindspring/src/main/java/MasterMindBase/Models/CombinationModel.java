package MasterMindBase.Models;

public class CombinationModel {
    String combinazione;

    public CombinationModel(String combinazione) {
        this.combinazione = combinazione;
    }

    public String setSql() {
        String sql = "INSERT INTO CodiceDiBase(CodiceBase) VALUES('" + combinazione + "')";
        return sql;
    }
}
