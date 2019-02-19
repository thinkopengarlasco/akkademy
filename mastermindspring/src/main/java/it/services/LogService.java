package it.services;

import it.DTO.LogDTO;
import it.models.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogService {

    private Dao instanceDao;

    public LogService(Dao instanceDao) {
        this.instanceDao = instanceDao;

    }

    public boolean controlloUtente(String username, String password) {
        ResultSet set;
        try {
            String sql = "SELECT * FROM LOGIN";
            set = instanceDao.prendiDaTabella(sql);
            while (set.next()) {
                LogDTO log = new LogDTO();
                log.setUsername(set.getString(2));
                if (username.equals(log.getUsername())) {
                    log.setPassword(set.getString(3));
                    if (password.equals(log.getPassword())) {
                        return true;
                    } else {
                        return false;
                    }
                } else {

                }

            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    public boolean registraUtente(String username, String password) {
        String timeStamp;
        LogDTO log = new LogDTO();
        log.setUsername(username);
        log.setPassword(password);
        log.setDataRegistrazione(timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date()));
        this.popolaTabella(username, password, timeStamp);
        return true;
    }

    public void popolaTabella(String username, String password, String timeStamp) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO LOGIN (ID, Username, Password, Data_Registrazione) VALUES ('0','");
        sql.append(username);
        sql.append("','");
        sql.append(password);
        sql.append("','");
        sql.append(timeStamp);
        sql.append("')");
        instanceDao.usaTabella(sql);
    }
}
