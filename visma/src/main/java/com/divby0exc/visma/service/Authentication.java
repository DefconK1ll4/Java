package com.divby0exc.visma.service;

import com.divby0exc.visma.model.Registrator;
import com.divby0exc.visma.repository.VismaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Service
public class Authentication {
    @Autowired
    VismaRepository repo;

    public String validateUser(Registrator user) {
        final int MAX_LENGTH = 15;
        final int MIN_LENGTH = 8;
        boolean isBlank = (user.getUsr() == null || user.getUsr().isBlank() || user.getUsr().isEmpty());
        String errorMsg = "";

        if (isBlank) {
            errorMsg = "Username cannot be blank";
        } else if(user.getUsr().length() < MIN_LENGTH) {
            errorMsg = "Your username needs to be atleast 8 characters";
        } else if(user.getUsr().length() > MAX_LENGTH) {
            errorMsg = "Your username is too long. Maximum amount of characters is 15";
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
        if(repo.findUserIfExist(user.getUsr())) {

        }


        return false;
    }
}
