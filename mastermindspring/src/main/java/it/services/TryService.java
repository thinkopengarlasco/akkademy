package it.services;

import it.models.TryModel;
import it.models.TryRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class TryService {
    private TryRepository tryRepository;

    public TryService(TryRepository tryRepository) {
        this.tryRepository = tryRepository;
    }

    public void save(int tentativi, int[] input, int[] esito) {
        String numeri = Arrays.toString(input);
        int posEsatta = esito[0];
        int numEsatto = esito[1];
        this.tryRepository.popolaTabella(tentativi, posEsatta, numEsatto, numeri);
    }

    public ArrayList<TryModel> getArrayListModel() {
        return tryRepository.convertToModel();
    }
}
