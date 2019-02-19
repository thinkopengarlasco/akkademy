package MasterMindBase;

import MasterMindBase.Login.Registrazione;
import MasterMindBase.Models.CombinationModel;
import MasterMindBase.Models.TryModel;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class Dao {
    private Connection con;
    public void connessione() {
        Dao dao = new Dao();
        try {
            System.out.println(dao.getConnection().isClosed());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void Insert(Object a){
        try {
            if (a instanceof TryModel) {
                PreparedStatement ps = getConnection().prepareStatement(((TryModel) a).setSql(), Statement.RETURN_GENERATED_KEYS);
                ps.executeUpdate();
            }
            if (a instanceof CombinationModel) {
                PreparedStatement ps = getConnection().prepareStatement(((CombinationModel) a).setSql(), Statement.RETURN_GENERATED_KEYS);
                ps.executeUpdate();
            }
            if (a instanceof Registrazione) {
                PreparedStatement ps = getConnection().prepareStatement(((Registrazione) a).setSql(), Statement.RETURN_GENERATED_KEYS);
                ps.executeUpdate();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet recupera(String s) throws SQLException{
        PreparedStatement ps = getConnection().prepareStatement(s);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public Connection getConnection() throws  SQLException {
        if(con == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("127.0.0.1");
            dataSource.setPortNumber(3306);
            dataSource.setUser("root");
            dataSource.setPassword("password");
            dataSource.setDatabaseName("MasterMind");

            con = dataSource.getConnection();
        }
        return con;
    }
}
