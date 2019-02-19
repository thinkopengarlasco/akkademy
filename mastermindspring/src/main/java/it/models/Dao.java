package it.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Dao {

    private static Dao instance;

    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String serverName;
    private String databaseName;
    private String username;
    private String password;
    private FileInputStream fin;
    private Properties p;
    private String url;
    private Connection connection;
    private Statement stmt;

    private Dao() {
        this.ConnessioneDb();
    }

    public static Dao newIstance() {
        if (instance == null) {
            instance = new Dao();
        }
        return instance;
    }

    public void ConnessioneDb() {
        try {
            this.fin = new FileInputStream("/home/nazario/IdeaProjects/provaMM/src/java/it/db.properties");
            this.p = new Properties();
            this.p.load(fin);
            this.serverName = p.getProperty("sN");
            this.databaseName = p.getProperty("dN");
            this.username = p.getProperty("uN");
            this.password = p.getProperty("uP");
            this.url = "jdbc:mysql://" + this.serverName + "/" + this.databaseName + "?user=" + this.username + "?password=" + this.password;
            Class.forName(this.driverName);
            System.out.println("Connessione al database selezionato ...");
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            System.out.println("Connessione effettuata!");
            this.stmt = this.connection.createStatement();
            this.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS COMBINATION (ID INTEGER PRIMARY KEY AUTO_INCREMENT," +
                    " User VARCHAR(20), Soluzione VARCHAR(20), Data_Operazione VARCHAR(30))");
            this.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS TRY (ID_COMB INTEGER ," +
                    " ID INTEGER , POS_ESATTA INTEGER, NUM_ESATTO INTEGER, VALORI_INSERITI VARCHAR(20)," +
                    " Data_Operazione VARCHAR(30), PRIMARY KEY (Data_operazione), FOREIGN KEY (ID_COMB) REFERENCES COMBINATION(ID))");
            this.stmt.executeUpdate("CREATE TABLE IF NOT EXISTS LOGIN (ID INTEGER PRIMARY KEY AUTO_INCREMENT, Username VARCHAR(15)," +
                    " Password VARCHAR(20), Data_Registrazione VARCHAR(30))");
            System.out.println("Accesso alla tabella!");

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void usaTabella(StringBuilder sql) {
        try {
            this.stmt.executeUpdate(sql.toString());
            //System.out.print("Registrazione effettuata!");
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public int prendiID() {
        int maxID = 0;
        try {
            ResultSet resultset = this.stmt.executeQuery("SELECT ID FROM  COMBINATION");
            while (resultset.next()) {
                maxID = resultset.getInt("ID");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return maxID;
    }

    public ResultSet prendiDaTabella(String sql) throws SQLException {
        ResultSet resultSet = this.stmt.executeQuery(sql);
        //System.out.println(resultSet.getString(2));
        return resultSet;

    }


}
