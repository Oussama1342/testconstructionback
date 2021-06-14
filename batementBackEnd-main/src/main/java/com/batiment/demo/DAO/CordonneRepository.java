package com.batiment.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batiment.demo.entity.Cordonnes;

@Repository
public interface CordonneRepository extends JpaRepository<Cordonnes, Integer> {

	
@Query("SELECT c FROM Cordonnes c WHERE c.idcordonne = (SELECT MAX(c.idcordonne) FROM Cordonnes c )" )
public List<Cordonnes>  findcordonned() ; 


@Query("SELECT c.tel FROM Cordonnes c WHERE c.idcordonne = (SELECT MAX(c.idcordonne) FROM Cordonnes c )" )
public String findtel() ; 


@Query("SELECT c.email FROM Cordonnes c WHERE c.idcordonne = (SELECT MAX(c.idcordonne) FROM Cordonnes c )" )
public String findmail() ;


@Query("SELECT c.adresse FROM Cordonnes c WHERE c.idcordonne = (SELECT MAX(c.idcordonne) FROM Cordonnes c )" )
public String findadress() ;


@Query("SELECT c.description FROM Cordonnes c WHERE c.idcordonne = (SELECT MAX(c.idcordonne) FROM Cordonnes c )" )
public String finddescription();

public Cordonnes findByIdcordonne(int idcred);
}





