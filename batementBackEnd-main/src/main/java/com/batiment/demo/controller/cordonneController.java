package com.batiment.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.batiment.demo.DAO.CordonneRepository;
import com.batiment.demo.entity.Cordonnes;

@RestController
@CrossOrigin("*")
public class cordonneController {

@Autowired
CordonneRepository cordonneRepository ;	


@PostMapping("/addcordone")
public Cordonnes addCordonne(@RequestBody Cordonnes cordonnes) {
	
	return cordonneRepository.save(cordonnes) ;
}


@GetMapping("/allcordonnes")
public  List<Cordonnes> allcordonnes(){
	
	
	return cordonneRepository.findcordonned() ;
}


@GetMapping("/gettel")
public String numtelGet() {
	
	return cordonneRepository.findtel();
	
}


@GetMapping("/getmail")
public String getEemail () {
	
	
	return cordonneRepository.findmail();
}

@GetMapping("/desciption")
public String getdescription() {
	
	return cordonneRepository.finddescription() ;
}

@GetMapping("/address")
public String getadress() {
	
	return cordonneRepository.findadress();
}

@GetMapping("/testcrd")
public List<Cordonnes> testcordonne(){
	
	return cordonneRepository.findAll() ;
}

@GetMapping("/findcrdt/{idcrdt}")
public Cordonnes findcordonne(@PathVariable int idcrdt) {
	
	return cordonneRepository.findByIdcordonne(idcrdt) ;
	
}




@PutMapping("/updatecord/{idcrdt}")
public Cordonnes updateCordonne(@RequestBody Cordonnes cordonnes, @PathVariable int idcrdt) {
	
	Cordonnes cordonnes2 = cordonneRepository.findByIdcordonne(idcrdt);
	cordonnes2.setTel(cordonnes.getTel());
	cordonnes2.setEmail(cordonnes.getEmail());
	cordonnes2.setDescription(cordonnes.getDescription());
	cordonnes2.setAdresse(cordonnes.getAdresse());
	
	cordonneRepository.save(cordonnes2);
	return cordonnes2 ;
	
	}




}
