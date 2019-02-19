package it.services;

import it.models.CombinationModel;
import it.models.CombinationRepository;
import it.services.utils.Checker;

import java.util.ArrayList;

public class CombinationService {
    private CombinationRepository combinationRepository;
    private Checker checkerMasterMind;
    private int[] soluzione = new int[3];

    public CombinationService(CombinationRepository combinationRepository, Checker checkerMasterMind) {
        this.combinationRepository = combinationRepository;
        this.checkerMasterMind = checkerMasterMind;
    }

    public int[] create() {
        for (int i = 0; i < this.soluzione.length; i++) {
            this.soluzione[i] = (int) (Math.random() * 10);
        }
        this.combinationRepository.popolaTabella(this.soluzione);
        return this.soluzione;

    }

    public void setUsername(String username) {
        this.combinationRepository.setUsername(username);
    }

    public int[] check(int[] soluzione, int[] input) {
        return this.checkerMasterMind.doCheck(soluzione, input);
    }

    public ArrayList<CombinationModel> getArrayListModel() {
        return combinationRepository.convertToModel();
    }
}


