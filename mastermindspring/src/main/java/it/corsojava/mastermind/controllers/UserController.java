package it.corsojava.mastermind.controllers;

import it.corsojava.mastermind.dto.UserDTO;
import it.corsojava.mastermind.services.UserService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private UserService UserService;

    public UserController() {
        UserService = new UserService();
    }

    public boolean addUser(String nome) {
        return UserService.addUser(nome);
    }

    public List<UserDTO> getUsers() {
        return UserService.getUsers();
    }

}
