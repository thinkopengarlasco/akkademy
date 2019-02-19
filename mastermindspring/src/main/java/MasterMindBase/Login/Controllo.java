package MasterMindBase.Login;

import MasterMindBase.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controllo {
    String Username;
    String Password;

    public Controllo(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    ResultSet rs;
    String recuperadati = "SELECT * FROM Login;";
    Dao dao = new Dao();

    public boolean control() {
        dao.connessione();
        try {
            rs = dao.recupera(recuperadati);
            while (rs.next()) {
                if(Username == rs.getString(2) && Password == rs.getString(3)){
                    return true;
                } else
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
