package it.services;

import it.DTO.UserDTO;
import it.models.CombinationModel;
import it.models.TryModel;
import it.services.utils.ClassificheService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class UserService implements ClassificheService {
    private CombinationService combinationService;
    private TryService tryService;

    public UserService(CombinationService combinationService, TryService tryService) {
        this.combinationService = combinationService;
        this.tryService = tryService;
    }

    @Override
    public ArrayList<UserDTO> prendiArrayList() {
        ArrayList<UserDTO> dtos = new ArrayList<>();

        ArrayList<CombinationModel> combinationList = combinationService.getArrayListModel();

        ArrayList<TryModel> tryList = tryService.getArrayListModel();

        Iterator<CombinationModel> it = combinationList.iterator();

        while (it.hasNext()) {
            CombinationModel current = it.next();

            UserDTO dto = new UserDTO();

            dto.setID(current.getId());
            dto.setNome(current.getUsername());
            dto.setPunteggio(this.calcolaPunteggio(tryList, current.getId()));
            dtos.add(dto);
        }
        Collections.sort(dtos);
        //System.out.println(dtos.toString());
        /*while(it2.hasNext())
        {
            it2.next();
            System.out.println("ID= "+dtos.get(1)+"\tNome= "+dtos.get(2)+"\tsetPunteggio= "+dtos.get(3));
        }*/
        return dtos;
    }

    public int calcolaPunteggio(ArrayList<TryModel> list, int id) {
        Iterator<TryModel> it = list.iterator();
        int contaPrimo = 0;
        int contaSecondo = 0;
        while (it.hasNext()) {
            TryModel current = it.next();
            if (current.getIdComb() == id) {
                contaPrimo++;
                if (current.getPosEsatta() == 3) {
                    contaSecondo++;
                }
            }
        }
        if (contaPrimo > 0) {
            return ((contaSecondo * 100) / contaPrimo);
        } else {
            return 0;
        }
    }
}
