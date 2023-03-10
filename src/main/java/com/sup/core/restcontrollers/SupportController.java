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

  @PostMapping("/category/create-category")
  public ResponseEntity<?> createCategory(@RequestParam String categoryName) {
    return ResponseEntity.ok(supportService.createCategory(categoryName));
  }

  @GetMapping("/category/get-category")
  public ResponseEntity<?> getCategory(@RequestParam Long categoryId) {
    return ResponseEntity.ok(supportService.getCategory(categoryId));
  }

  @GetMapping("/category/get-all-categories")
  public ResponseEntity<?> getAllCategories() {
    return ResponseEntity.ok(supportService.getAllCategories());
  }

  @GetMapping("/category/get-category-subcategories")
  public ResponseEntity<?> getCategorySubcategories(@RequestParam Long categoryId) {
    return ResponseEntity.ok(supportService.getCategorySubcategories(categoryId));
  }

  @PutMapping("/category/edit-category")
  public ResponseEntity<?> editCategory(@RequestParam Long categoryId, @RequestParam String newCategoryName) {
    return ResponseEntity.ok(supportService.editCategory(categoryId, newCategoryName));
  }

  @DeleteMapping("/category/delete-category")
  public ResponseEntity<?> deleteCategory(@RequestParam Long categoryId) {
    return ResponseEntity.ok(supportService.deleteCategory(categoryId));
  }

  // <======= SUBCATEGORY RELATED =======>

  @PostMapping("/subcategory/create-subcategory")
  public ResponseEntity<?> createSubcategory(@RequestParam Long categoryId, @RequestParam String categoryName) {
    return ResponseEntity.ok(supportService.createSubcategory(categoryId, categoryName));
  }

  @GetMapping("/subcategory/get-subcategory")
  public ResponseEntity<?> getSubcategory(@RequestParam Long subcategoryId) {
    return ResponseEntity.ok(supportService.getSubcategory(subcategoryId));
  }

  @PutMapping("/subcategory/edit-subcategory")
  public ResponseEntity<?> editSubcategory(@RequestParam Long subcategoryId, @RequestParam String newSubcategoryName) {
    return ResponseEntity.ok(supportService.editSubcategory(subcategoryId, newSubcategoryName));
  }

  @DeleteMapping("/subcategory/delete-subcategory")
  public ResponseEntity<?> deleteSubcategory(@RequestParam Long subcategoryId) {
    return ResponseEntity.ok(supportService.deleteSubcategory(subcategoryId));
  }

  // <======= ARTICLE RELATED =======>

  @PostMapping("/article/create-article")
  public ResponseEntity<?> createArticle(@RequestBody SupportArticleRequestModel supportArticleRequestModel) {
    return ResponseEntity.ok(supportService.createArticle(supportArticleRequestModel));
  }

  @GetMapping("/article/get-article")
  public ResponseEntity<?> getArticle(@RequestParam Long articleId) {
    return ResponseEntity.ok(supportService.getArticle(articleId));
  }

  @GetMapping("/article/get-subcategory-articles")
  public ResponseEntity<?> getArticlesBySubcategory(@RequestParam Long subcategoryId) {
    return ResponseEntity.ok(supportService.getArticlesBySubcategory(subcategoryId));
  }

  @PutMapping("/article/edit-article")
  public ResponseEntity<?> editArticle(@RequestBody SupportArticleUpdateRequestModel supportArticleRequestModel) {
    return ResponseEntity.ok(supportService.editArticle(supportArticleRequestModel));
  }

  @DeleteMapping("/article/delete-article")
  public ResponseEntity<?> deleteArticle(@RequestParam Long articleId) {
    return ResponseEntity.ok(supportService.deleteArticle(articleId));
  }
}
