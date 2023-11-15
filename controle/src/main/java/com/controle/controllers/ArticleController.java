package com.controle.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controle.entities.Article;
import com.controle.services.ArticleService;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {
	@Autowired
	private ArticleService service;

	@GetMapping
	public List<Article> findAllArticle() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Article article = service.findById(id);
		if (article == null) {
			return new ResponseEntity<Object>("Article avec Id " + id + " n existe pas", HttpStatus.BAD_REQUEST);

		} else {
			return ResponseEntity.ok(article);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteArticle(@PathVariable Long id) {
		Article article = service.findById(id);
		if (article == null) {
			return new ResponseEntity<Object>("Article avec Id " + id + " n existe pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(article);
			return ResponseEntity.ok("article avec id " + id + " suprime");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateArticle(@PathVariable Long id, @RequestBody Article newarticle) {

		Article oldArticle = service.findById(id);
		if (oldArticle == null) {
			return new ResponseEntity<Object>("article avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

		} else {
			newarticle.setId(id);
			return ResponseEntity.ok(service.update(newarticle));
		}
	}

	@PostMapping
	public Article createArticle(@RequestBody Article article) {
		article.setId(0L);
		return service.create(article);
	}
}
