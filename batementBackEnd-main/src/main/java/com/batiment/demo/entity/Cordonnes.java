package com.batiment.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cordonnes {

	@Id
	@GeneratedValue
	private int idcordonne ;
	
	private String tel ;
	
	private String email ;
	private String description ;
	
	private String adresse ;
	
	private String image ; 
	
	
	public int getIdcordonne() {
		return idcordonne;
	}
	public void setIdcordonne(int idcordonne) {
		this.idcordonne = idcordonne;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
