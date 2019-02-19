package MasterMindBase.Login;

public class Registrazione {
    String Username;
    String Password;

    public Registrazione(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public String setSql() {
        String sql = "INSERT INTO Login(Username, Password) VALUES('" + Username + "', '"+Password+"')";
        return sql;
    }
}