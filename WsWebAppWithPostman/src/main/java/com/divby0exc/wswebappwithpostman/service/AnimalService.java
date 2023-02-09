package com.divby0exc.wswebappwithpostman.service;

import com.divby0exc.wswebappwithpostman.model.Animal;


public interface AnimalService {
    public Animal save(Animal a);

    public void deleteAnimalById(Long id);


}
