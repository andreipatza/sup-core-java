package com.sup.core.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sup.core.models.support.SupportArticleRequestModel;
import com.sup.core.models.support.SupportArticleUpdateRequestModel;
import com.sup.core.services.SupportService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/support")
public class SupportController {

  private final SupportService supportService;

  // <======= CATEGORY RELATED =======>

  @PostMapping("/create-category")
  public ResponseEntity<?> createCategory(@RequestParam String categoryName) {
    return ResponseEntity.ok(supportService.createCategory(categoryName));
  }

  @GetMapping("/get-category")
  public ResponseEntity<?> getCategory(@RequestParam Long categoryId) {
    return ResponseEntity.ok(supportService.getCategory(categoryId));
  }

  @GetMapping("/get-all-categories")
  public ResponseEntity<?> getAllCategories() {
    return ResponseEntity.ok(supportService.getAllCategories());
  }

  @GetMapping("/get-category-subcategories")
  public ResponseEntity<?> getCategorySubcategories(@RequestParam Long categoryId) {
    return ResponseEntity.ok(supportService.getCategorySubcategories(categoryId));
  }

  @PutMapping("/edit-category")
  public ResponseEntity<?> editCategory(@RequestParam Long categoryId, @RequestParam String newCategoryName) {
    return ResponseEntity.ok(supportService.editCategory(categoryId, newCategoryName));
  }

  @DeleteMapping("/delete-category")
  public ResponseEntity<?> deleteCategory(@RequestParam Long categoryId) {
    return ResponseEntity.ok(supportService.deleteCategory(categoryId));
  }

  // <======= SUBCATEGORY RELATED =======>

  @PostMapping("/create-subcategory")
  public ResponseEntity<?> createSubcategory(@RequestParam Long categoryId, @RequestParam String categoryName) {
    return ResponseEntity.ok(supportService.createSubcategory(categoryId, categoryName));
  }

  @GetMapping("/get-subcategory")
  public ResponseEntity<?> getSubcategory(@RequestParam Long subcategoryId) {
    return ResponseEntity.ok(supportService.getSubcategory(subcategoryId));
  }

  @PutMapping("/edit-subcategory")
  public ResponseEntity<?> editSubcategory(@RequestParam Long subcategoryId, @RequestParam String newSubcategoryName) {
    return ResponseEntity.ok(supportService.editSubcategory(subcategoryId, newSubcategoryName));
  }

  @DeleteMapping("/delete-subcategory")
  public ResponseEntity<?> deleteSubcategory(@RequestParam Long subcategoryId) {
    return ResponseEntity.ok(supportService.deleteSubcategory(subcategoryId));
  }

  // <======= ARTICLE RELATED =======>

  @PostMapping("/create-article")
  public ResponseEntity<?> createArticle(@RequestBody SupportArticleRequestModel supportArticleRequestModel) {
    return ResponseEntity.ok(supportService.createArticle(supportArticleRequestModel));
  }

  @GetMapping("/get-article")
  public ResponseEntity<?> getArticle(@RequestParam Long articleId) {
    return ResponseEntity.ok(supportService.getArticle(articleId));
  }

  @GetMapping("/get-subcategory-articles")
  public ResponseEntity<?> getArticlesBySubcategory(@RequestParam Long subcategoryId) {
    return ResponseEntity.ok(supportService.getArticlesBySubcategory(subcategoryId));
  }

  @PutMapping("/edit-article")
  public ResponseEntity<?> editArticle(@RequestBody SupportArticleUpdateRequestModel supportArticleRequestModel) {
    return ResponseEntity.ok(supportService.editArticle(supportArticleRequestModel));
  }

  @DeleteMapping("/delete-article")
  public ResponseEntity<?> deleteArticle(@RequestParam Long articleId) {
    return ResponseEntity.ok(supportService.deleteArticle(articleId));
  }
}
