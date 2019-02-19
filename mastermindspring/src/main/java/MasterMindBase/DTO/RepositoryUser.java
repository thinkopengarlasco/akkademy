package MasterMindBase.DTO;
import MasterMindBase.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class RepositoryUser {
    ResultSet rs;

    String recuperadati = "SELECT * FROM Prova;";
    Dao dao = new Dao();

    public ArrayList<UserModel> databalist() {
        dao.connessione();
        ArrayList<UserModel> userarraylist = new ArrayList<>();
        try {
            rs = dao.recupera(recuperadati);
            while (rs.next()) {
                UserModel u = new UserModel();
                u.setid(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setPn(Integer.parseInt(rs.getString(5)));
                u.setN(Integer.parseInt(rs.getString(6)));
                userarraylist.add(u);
            }
            return userarraylist;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.sort(userarraylist);
        return userarraylist;
    }
}
