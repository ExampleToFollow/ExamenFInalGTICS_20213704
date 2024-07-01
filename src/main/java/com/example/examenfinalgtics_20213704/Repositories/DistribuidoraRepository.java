package com.example.examenfinalgtics_20213704.Repositories;

import com.example.examenfinalgtics_20213704.Entities.Distribuidora;
import com.example.examenfinalgtics_20213704.Entities.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuidoraRepository extends JpaRepository<Distribuidora, Integer> {
}
