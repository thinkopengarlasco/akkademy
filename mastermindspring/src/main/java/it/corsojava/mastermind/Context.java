package it.corsojava.mastermind;

import it.corsojava.mastermind.controllers.Controller;
import it.corsojava.mastermind.models.CombinationModel;
import it.corsojava.mastermind.models.TryModel;
import it.corsojava.mastermind.services.CombinationService;
import it.corsojava.mastermind.services.TryService;
import it.corsojava.mastermind.services.ValidatorService;
import it.corsojava.mastermind.services.utils.Checker;
import it.corsojava.mastermind.services.utils.CheckerMasterMind;

public class Context {
    private static Context istanzaContesto;
    private Controller controller;

 //add metodo
    public static Context getInstance() {
        if (istanzaContesto == null) {
            istanzaContesto = new Context();
        }
        return istanzaContesto;
    }

    private Context()
    {
        Checker checkerMasterMind=new CheckerMasterMind();
        TryModel tryModel=new TryModel();
        CombinationModel combinationModel=new CombinationModel();
        CombinationService combinationService=new CombinationService(combinationModel, checkerMasterMind);
        TryService tryService=new TryService();
        ValidatorService validatorService=new ValidatorService();
        this.controller=new Controller(validatorService, combinationService, tryService);
        this.controller.setTryModel(tryModel);
    }

    public Controller getController(){
        return  this.controller;
    }

}
