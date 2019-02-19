package it.services;

import it.DTO.TentativoDTO;
import it.models.CombinationModel;
import it.models.TryModel;
import it.services.utils.ClassificheService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class TentativeService implements ClassificheService {

    private CombinationService combinationService;
    private TryService tryService;

    public TentativeService(CombinationService combinationService, TryService tryService) {
        this.combinationService = combinationService;
        this.tryService = tryService;
    }

    @Override
    public ArrayList<TentativoDTO> prendiArrayList() {
        ArrayList<TentativoDTO> dtos = new ArrayList<>();

        ArrayList<CombinationModel> combinationList = combinationService.getArrayListModel();

        ArrayList<TryModel> tryList = tryService.getArrayListModel();

        Iterator<TryModel> it = tryList.iterator();
        while (it.hasNext()) {
            TryModel current = it.next();
            TentativoDTO dto = new TentativoDTO();
            dto.setIDComb(current.getIdComb());
            dto.setPosEsatta(current.getPosEsatta());
            dto.setNumEsatto(current.getNumEsatto());
            dto.setInput(current.getInput());
            dto.setnTentativi(current.getId());
            dto.setUser(this.prendiUser(combinationList, dto.getID()));
            dto.setSoluzione(this.prendiSoluzione(combinationList, dto.getID()));
            dtos.add(dto);
            //System.out.println("User= "+ dto.getUser()+" nTentativi= "+current.getId()+" "+"\tPosEsatta= "+current.getPosEsatta()+"\tNumEsatto= "+current.getNumEsatto()
            //      +"\tSoluzione= "+dto.getSoluzione()+"\tInput= "+current.getInput());
        }
        Collections.sort(dtos);
        System.out.println(dtos.toString());
        return dtos;
    }


    public String prendiUser(ArrayList<CombinationModel> list, int id) {
        Iterator<CombinationModel> it = list.iterator();
        while (it.hasNext()) {
            CombinationModel current = it.next();
            if (current.getId() == id) {
                return current.getUsername();  //ne prende solo uno e si ferma
            }
        }
        return null;
    }


    public String prendiSoluzione(ArrayList<CombinationModel> list, int id) {
        Iterator<CombinationModel> it = list.iterator();
        while (it.hasNext()) {
            CombinationModel current = it.next();
            if (current.getId() == id) {
                return current.getSoluzione();
            }
        }
        return null;
    }
}
