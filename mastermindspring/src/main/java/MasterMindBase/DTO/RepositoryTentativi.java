package MasterMindBase.DTO;
import MasterMindBase.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepositoryTentativi {
    String recuperadati = "SELECT * FROM Prova;";
    ResultSet rs;
    Dao dao = new Dao();

    public ArrayList<TentativiModel> databalist() {
        dao.connessione();
        ArrayList<TentativiModel> tentarraylist = new ArrayList<>();
        try {
            rs = dao.recupera(recuperadati);
            while (rs.next()) {
                TentativiModel u = new TentativiModel();
                u.setUsername(rs.getString(2));
                u.setCodicebase(rs.getString(3));
                u.setCodiceinserito(rs.getString(4));
                u.setPn(Integer.parseInt(rs.getString(5)));
                u.setN(Integer.parseInt(rs.getString(6)));
                u.setResult(rs.getBoolean(7));
                tentarraylist.add(u);
            }
            return tentarraylist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tentarraylist;
    }
}
