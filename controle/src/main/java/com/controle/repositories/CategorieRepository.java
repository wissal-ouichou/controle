package com.controle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controle.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	public static final List<Categorie> categorie = null;
	

}
