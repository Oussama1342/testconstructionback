package com.batiment.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batiment.demo.entity.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

	public Equipe findByidEquipe(int idEquipe) ;
}
