package it.controllers;

import it.DTO.TentativoDTO;
import it.DTO.UserDTO;
import it.services.TentativeService;
import it.services.UserService;

import java.util.ArrayList;

public class ControllerClassifiche {
    private UserService userService;
    private TentativeService tentativeService;

    public ControllerClassifiche(UserService userService, TentativeService tentativeService) {
        this.userService = userService;
        this.tentativeService = tentativeService;
    }

    public ArrayList<UserDTO> classificaUser() {
        //this.userService.prendiArrayList().sort((Comparator<? super UserDTO>) this.userService.prendiArrayList());
        return this.userService.prendiArrayList();
    }

    public ArrayList<TentativoDTO> classificaTentativi() {
        return this.tentativeService.prendiArrayList();
    }


}
