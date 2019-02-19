package it.corsojava.mastermind.services;

import it.corsojava.mastermind.repository.Dao;

public class DAOService {
    private Dao dao;

    public DAOService (){
        dao = Dao.getInstance();
    }

    public void createTableModel()   {
        dao.createTableModel();
    }
}
