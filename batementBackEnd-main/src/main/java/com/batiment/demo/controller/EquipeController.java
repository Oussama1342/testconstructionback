package com.batiment.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.batiment.demo.DAO.EquipeRepository;
import com.batiment.demo.entity.Equipe;

@RestController
@CrossOrigin("*")
public class EquipeController {

	@Autowired
	EquipeRepository equipeRepository ;
	
	@PostMapping("/addequipe")
	public Equipe addEquipe(@RequestBody Equipe equipe) {
		
		return equipeRepository.save(equipe);
	}
	
	@GetMapping("/allequipe")
	public List<Equipe> allEquipe(){
		
		return equipeRepository.findAll(); 
	}
	
	@PutMapping("/editequip/{idequipe}")
	public Equipe editEquipe(@RequestBody Equipe  equipe , @PathVariable int idequipe) {
		
		Equipe equipe2 = equipeRepository.findByidEquipe(idequipe) ;
		
		equipe2.setNom(equipe.getNom());
		equipe2.setDescription(equipe.getDescription());
		
		equipeRepository.save(equipe2);
		
		return equipe2 ;
	}
	
	@GetMapping("/getequip/{idequip}")
	public Equipe getequipebyid(@PathVariable int idequip) {
		
		
		return equipeRepository.findByidEquipe(idequip);
	}
	
	@DeleteMapping("/deletequipe/{idequipe}")
	public Equipe deletEquipe(@PathVariable int idequipe) {
		
		Equipe equipe = equipeRepository.findByidEquipe(idequipe) ; 
		
		equipeRepository.delete(equipe);
		
		return equipe ;
		
	}
}
