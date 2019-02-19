package it.corsojava.mastermind.controllers;

import it.corsojava.mastermind.models.TryModel;
import it.corsojava.mastermind.services.CombinationService;
import it.corsojava.mastermind.services.DAOService;
import it.corsojava.mastermind.services.TryService;
import it.corsojava.mastermind.services.ValidatorService;

@org.springframework.stereotype.Controller
public class Controller {

    private DAOService daoService;
    private ValidatorService validatorService;
    private CombinationService combinationService;
    private TryService tryService;

    private TryModel tryModel;

    public Controller() {
        daoService = new DAOService();
    }
    public Controller(ValidatorService validatorService, CombinationService combinationService, TryService tryService) {
        this.combinationService=combinationService;
        this.validatorService=validatorService;
        this.tryService=tryService;
    }

    public void creaCombinazione()
    {
        this.combinationService.createCombination();
    }

    public void verificaInput(String combination)
    {

        tryModel.setUserTry(validatorService.controlloInput(combination));
    }

    public void createTableModel() {

        daoService.createTableModel();
    }

    public void verificaCombinazione()
    {
        int[] array = this.combinationService.getCombination();
        this.tryModel.setEsito(this.combinationService.check(array,this.tryModel.getUserTry()));
    }

    public void salvaGiocata( TryModel currentTry)
    {
        this.tryService.saveTry(currentTry);
    }

    public CombinationService getCombinationService() {
        return combinationService;
    }

    public TryModel getTryModel() {
        return tryModel;
    }

    public void setTryModel(TryModel tryModel) {
        this.tryModel = tryModel;
    }

}
