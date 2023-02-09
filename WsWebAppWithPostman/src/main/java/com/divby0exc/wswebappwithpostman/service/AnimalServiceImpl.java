package com.divby0exc.wswebappwithpostman.service;

import com.divby0exc.wswebappwithpostman.model.Animal;
import com.divby0exc.wswebappwithpostman.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public Animal save(Animal a) {
        return animalRepository.save(a);
    }


    public Animal getAnimalById(Long id) {
        Animal a = animalRepository.getAnimalById(id);

        return a;
    }

    @Override
    public void deleteAnimalById(Long id) {
        Animal e = getAnimalById(id);
        if(e!=null) {
            animalRepository.delete(e);
        } else {
            throw new EntityNotFoundException("No animal with ID: " + id);
        }
    }
    public List<Animal> getAnimalsById(Long id) {
        return animalRepository.getAnimalsById(id);
    }
}
