package it.corsojava.mastermind.services;

import it.corsojava.mastermind.models.TryModel;
import it.corsojava.mastermind.repository.TryDao;

public class TryService {
    private TryDao tryDao;


    public TryService() {}

    public boolean saveTry(TryModel tryModel)
    {
       return  tryDao.saveTry(tryModel);
    }
}
