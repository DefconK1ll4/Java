package com.divby0exc.visma.service;

import com.divby0exc.visma.model.Registrator;
import com.divby0exc.visma.repository.VismaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PseudoColumnUsage;

@Service
public class Authentication {
    @Autowired
    VismaRepository repo;

    public String validateNewUser(Registrator user) {
        final int MIN_LENGTH = 8;
        boolean isBlank = (user.getUsr() == null || user.getUsr().isBlank() || user.getUsr().isEmpty());
        String errorMsg = "";

        if (isBlank) {
            errorMsg = "Username cannot be blank";
        } else if(user.getUsr().length() < MIN_LENGTH) {
            errorMsg = "Your username needs to be atleast 8 characters";
        } else if(user.getPwd().length() < MIN_LENGTH) {
            errorMsg = "Your password needs to be atleast 8 characters";
        } else if(repo.findUserIfExist(user.getUsr())) {
            errorMsg = "Username already in use";
        } else {
            errorMsg = "success";
            repo.addUserToDB(user);
        }

        return errorMsg;
    }

    public boolean authenticateUser(Registrator user) {
        System.out.println(user.getUsr() + " From Form");
        System.out.println(user.getPwd() + " From Form");
        boolean userExist = repo.findUserIfExist(user.getUsr());

        if(!userExist) {
            System.err.println("User was not found in database");
            return false;
        } else if(repo.retrieveCredentials(user.getUsr())==null) {
            System.err.println("To be retrieved user was null");
            return false;
        } else if(!(repo.retrieveCredentials(user.getUsr()).getUsr().equals(user.getUsr())
        && repo.retrieveCredentials(user.getUsr()).getPwd().equals(user.getPwd()))) {
            System.err.println("User credentials didn't match");
            return false;
        } else return true;
    }
}
