package it.corsojava.mastermind.controllers;

import it.corsojava.mastermind.services.CombinationService;
import org.springframework.stereotype.Controller;

@Controller
public class CombinationController {
    private CombinationService combinationService;

    public CombinationController() {
        combinationService = new CombinationService();
    }

    public boolean addCombination(int[] array) {

        return combinationService.addCombination(array);
    }
}
