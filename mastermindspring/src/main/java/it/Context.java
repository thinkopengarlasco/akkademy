package it;

import it.controllers.Controller;
import it.controllers.ControllerClassifiche;
import it.models.CombinationRepository;
import it.models.Dao;
import it.models.TryRepository;
import it.services.*;
import it.services.utils.Checker;
import it.services.utils.CheckerMasterMind;

public class Context {
    private static Context istanzaContesto;
    private Controller controller;
    private ControllerClassifiche controllerClassifiche;


    public static Context getInstance() {
        if (istanzaContesto == null) {
            istanzaContesto = new Context();
        }
        return istanzaContesto;
    }

    private Context() {
        Checker checkerMasterMind = new CheckerMasterMind();
        //Comparatore comparatore=new Comparatore();
        Dao instanceDao = Dao.newIstance();
        LogService logService = new LogService(instanceDao);
        TryRepository tryRepository = new TryRepository(instanceDao);
        CombinationRepository combinationRepository = new CombinationRepository(instanceDao);
        CombinationService combinationService = new CombinationService(combinationRepository, checkerMasterMind);
        TryService tryService = new TryService(tryRepository);
        TentativeService tentativeService = new TentativeService(combinationService, tryService);
        UserService userService = new UserService(combinationService, tryService);
        ValidatorService validatorService = new ValidatorService();
        this.controllerClassifiche = new ControllerClassifiche(userService, tentativeService);
        this.controller = new Controller(validatorService, combinationService, tryService, logService);
    }

    public Controller getController() {
        return this.controller;
    }

    public ControllerClassifiche getControllerClassifiche() {
        return this.controllerClassifiche;
    }

}
