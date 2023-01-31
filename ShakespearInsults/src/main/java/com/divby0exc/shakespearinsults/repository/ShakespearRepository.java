package com.divby0exc.shakespearinsults.repository;

import com.divby0exc.shakespearinsults.model.ShakespearModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShakespearRepository extends JpaRepository<ShakespearModel, Long> {
}
