package com.controle.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controle.dao.IDao;
import com.controle.entities.Categorie;
import com.controle.repositories.CategorieRepository;

@Service
public class CategorieService implements IDao<Categorie> {
	@Autowired
   private CategorieRepository categorieRepository;
    @Override
    public Categorie create(Categorie o) {
       return categorieRepository.save(o);
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie update(Categorie o) {
        return categorieRepository.save(o);
    }

    @Override
    public boolean delete(Categorie o) {
        try {
            categorieRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Categorie findById(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

}
