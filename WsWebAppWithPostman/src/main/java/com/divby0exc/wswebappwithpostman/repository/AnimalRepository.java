package com.divby0exc.wswebappwithpostman.repository;

import com.divby0exc.wswebappwithpostman.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    public List<Animal> getAnimalsById(Long id);
    public Animal getAnimalById(Long id);

}
