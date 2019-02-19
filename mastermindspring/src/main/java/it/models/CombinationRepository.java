package it.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class CombinationRepository implements Repository {
    private Dao instanceDao;
    private String username;
    private String timeStamp;

    public CombinationRepository(Dao instanceDao) {
        this.instanceDao = instanceDao;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void popolaTabella(int[] soluzione) {
        this.timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO COMBINATION (ID, User, Soluzione, Data_Operazione) VALUES ('0','");
        sql.append(this.username);
        sql.append("','");
        sql.append(Arrays.toString(soluzione));
        sql.append("','");
        sql.append(this.timeStamp);
        sql.append("')");
        instanceDao.usaTabella(sql);
    }

    @Override
    public ArrayList<CombinationModel> convertToModel() {
        ResultSet set;
        ArrayList<CombinationModel> combinationModelArrayList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM COMBINATION";
            set = instanceDao.prendiDaTabella(sql);
            while (set.next()) {
                final CombinationModel ob = new CombinationModel();
                ob.setId(set.getInt(1));
                ob.setUsername(set.getString(2));
                ob.setSoluzione(set.getString(3));
                ob.setData(set.getString(4));
                combinationModelArrayList.add(ob);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return combinationModelArrayList;
    }
}
