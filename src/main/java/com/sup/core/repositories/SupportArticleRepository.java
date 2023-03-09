package com.sup.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sup.core.entities.SupportArticle;
import com.sup.core.entities.SupportSubcategory;

public interface SupportArticleRepository extends JpaRepository<SupportArticle, Long> {
  List<SupportArticle> findBySubcategory(SupportSubcategory subcategory);
}
