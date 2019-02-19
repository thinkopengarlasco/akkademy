package it.corsojava.mastermind.javaBean;

import it.corsojava.mastermind.dto.UserDTO;

import java.util.ArrayList;

public class UserBean {

    private ArrayList<UserDTO> listaUtenti;

    public UserBean(){
        listaUtenti = new ArrayList<>();
    }

    public ArrayList<UserDTO> getUtenti() {
        return listaUtenti;
    }

    public void setUtenti(ArrayList<UserDTO> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }
}
