package com.example.examenfinalgtics_20213704.Repositories;

import com.example.examenfinalgtics_20213704.Entities.Juego;
import com.example.examenfinalgtics_20213704.Entities.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PlataformaRepository extends JpaRepository<Plataforma, Integer> {
}
