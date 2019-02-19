package it.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TryRepository implements Repository {
    private Dao instanceDao;
    private String timeStamp;

    public TryRepository(Dao instanceDao) {
        this.instanceDao = instanceDao;
    }

    public void popolaTabella(int tentativi, int posEsatta, int numEsatto, String numeri) {
        this.timeStamp = new SimpleDateFormat("dd.MM.yyyy - HH.mm.ss").format(new Date());
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO TRY (ID_COMB, ID, POS_ESATTA, NUM_ESATTO, VALORI_INSERITI, Data_Operazione) VALUES ('");
        sql.append(instanceDao.prendiID());
        sql.append("', '");
        sql.append(tentativi);
        sql.append("', '");
        sql.append(posEsatta);
        sql.append("', '");
        sql.append(numEsatto);
        sql.append("', '");
        sql.append(numeri);
        sql.append("', '");
        sql.append(this.timeStamp);
        sql.append("')");
        instanceDao.usaTabella(sql);
    }

    @Override
    public ArrayList<TryModel> convertToModel() {
        ResultSet set;
        ArrayList<TryModel> tryModelArrayList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TRY ORDER BY ID_COMB, ID ";
            set = instanceDao.prendiDaTabella(sql);
            while (set.next()) {
                final TryModel ob = new TryModel();
                ob.setIdComb(set.getInt(1));
                ob.setId(set.getInt(2));
                ob.setPosEsatta(set.getInt(3));
                ob.setNumEsatto(set.getInt(4));
                ob.setInput(set.getString(5));
                ob.setData(set.getString(6));
                tryModelArrayList.add(ob);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return tryModelArrayList;
    }
}
