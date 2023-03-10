package com.sup.core.services;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sup.core.entities.SupportArticle;
import com.sup.core.entities.SupportCategory;
import com.sup.core.entities.SupportSubcategory;
import com.sup.core.models.support.SupportArticleRequestModel;
import com.sup.core.models.support.SupportArticleUpdateRequestModel;
import com.sup.core.repositories.SupportArticleRepository;
import com.sup.core.repositories.SupportCategoryRepository;
import com.sup.core.repositories.SupportSubcategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SupportService {

  private final SupportCategoryRepository supportCategoryRepository;
  private final SupportSubcategoryRepository supportSubcategoryRepository;
  private final SupportArticleRepository supportArticleRepository;

  // <======= CATEGORY RELATED =======>

  public SupportCategory createCategory(String categoryName) {
    SupportCategory existingCategory = supportCategoryRepository.findByName(categoryName).orElse(null);
    if (Objects.isNull(existingCategory)) {
      SupportCategory newCategory = new SupportCategory();
      newCategory.setName(categoryName);
      newCategory = supportCategoryRepository.save(newCategory);
      return newCategory;
    } else {
      throw new RuntimeException("A category with this name already exists!");
    }
  }

  public SupportCategory getCategory(Long categoryId) {
    SupportCategory existingCategory = supportCategoryRepository.findById(categoryId).orElse(null);
    if (Objects.nonNull(existingCategory)) {
      return existingCategory;
    } else {
      throw new RuntimeException("There is no category with provided categoryId!");
    }
  }

  public List<SupportCategory> getAllCategories() {
    List<SupportCategory> categories = supportCategoryRepository.findAll();
    return categories;
  }

  public List<SupportSubcategory> getCategorySubcategories(Long categoryId) {
    SupportCategory existingCategory = supportCategoryRepository.findById(categoryId).orElse(null);
    if (Objects.nonNull(existingCategory)) {
      List<SupportSubcategory> subcategories = supportSubcategoryRepository.findByCategory(existingCategory);
      return subcategories;
    } else {
      throw new RuntimeException("There is no category with provided categoryId!");
    }
  }

  public SupportCategory editCategory(Long categoryId, String newCategoryName) {
    SupportCategory existingCategory = supportCategoryRepository.findById(categoryId).orElse(null);
    if (Objects.nonNull(existingCategory)) {
      existingCategory.setName(newCategoryName);
      supportCategoryRepository.save(existingCategory);
      return existingCategory;
    } else {
      throw new RuntimeException("There is no category with provided categoryId!");
    }
  }

  public String deleteCategory(Long categoryId) {
    SupportCategory existingCategory = supportCategoryRepository.findById(categoryId).orElse(null);
    if (Objects.nonNull(existingCategory)) {
      List<SupportSubcategory> subcategories = supportSubcategoryRepository.findByCategory(existingCategory);
      if (subcategories.size() == 0) {
        supportCategoryRepository.delete(existingCategory);
        return "Category deleted!";
      } else {
        throw new RuntimeException("The category has subcategories assigned, it cannot be deleted!");
      }
    } else {
      throw new RuntimeException("There is no category with provided categoryId!");
    }
  }

  // <======= SUBCATEGORY RELATED =======>

  public SupportSubcategory createSubcategory(Long categoryId, String subcategoryName) {
    SupportCategory existingCategory = supportCategoryRepository.findById(categoryId).orElse(null);
    if (Objects.nonNull(existingCategory)) {
      SupportSubcategory existingSubcategory = supportSubcategoryRepository.findByName(subcategoryName).orElse(null);
      if (Objects.isNull(existingSubcategory)) {
        SupportSubcategory newSubCategory = new SupportSubcategory();
        newSubCategory.setName(subcategoryName);
        newSubCategory.setCategory(existingCategory);
        newSubCategory = supportSubcategoryRepository.save(newSubCategory);
        return newSubCategory;
      } else {
        throw new RuntimeException("A subcategory with this name already exists!");
      }
    } else {
      throw new RuntimeException("There is no subcategory with provided categoryId!");
    }
  }

  public SupportSubcategory getSubcategory(Long subcategoryId) {
    SupportSubcategory existingSubcategory = supportSubcategoryRepository.findById(subcategoryId).orElse(null);
    if (Objects.nonNull(existingSubcategory)) {
      return existingSubcategory;
    } else {
      throw new RuntimeException("There is no subcategory with provided subcategoryId!");
    }
  }

  public SupportSubcategory editSubcategory(Long subcategoryId, String newSubcategoryName) {
    SupportSubcategory existingSubcategory = supportSubcategoryRepository.findById(subcategoryId).orElse(null);
    if (Objects.nonNull(existingSubcategory)) {
      existingSubcategory.setName(newSubcategoryName);
      supportSubcategoryRepository.save(existingSubcategory);
      return existingSubcategory;
    } else {
      throw new RuntimeException("There is no subcategory with provided subcategoryId!");
    }
  }

  public String deleteSubcategory(Long subcategoryId) {
    SupportSubcategory existingSubcategory = supportSubcategoryRepository.findById(subcategoryId).orElse(null);
    if (Objects.nonNull(existingSubcategory)) {
      List<SupportArticle> articles = supportArticleRepository.findBySubcategory(existingSubcategory);
      if (articles.size() == 0) {
        supportSubcategoryRepository.delete(existingSubcategory);
        return "Subcategory delted!";
      } else {
        throw new RuntimeException("The subcategory has articles assigned, it cannot be deleted!");
      }
    } else {
      throw new RuntimeException("There is no subcategory with provided categoryId!");
    }
  }

  // <======= ARTICLE RELATED =======>

  public SupportArticle createArticle(SupportArticleRequestModel supportArticleRequestModel) {
    SupportSubcategory existingSubcategory = supportSubcategoryRepository
        .findById(supportArticleRequestModel.getSubcategoryId()).orElse(null);
    if (Objects.nonNull(existingSubcategory)) {
      SupportArticle newArticle = new SupportArticle();
      newArticle.setSubcategory(existingSubcategory);
      newArticle.setTitle(supportArticleRequestModel.getTitle());
      newArticle.setContent(supportArticleRequestModel.getContent());
      newArticle = supportArticleRepository.save(newArticle);
      return newArticle;
    } else {
      throw new RuntimeException("There is no subcategory with provided subcategoryId!");
    }
  }

  public SupportArticle getArticle(Long articleId) {
    SupportArticle existingArticle = supportArticleRepository.findById(articleId).orElse(null);
    if (Objects.nonNull(existingArticle)) {
      return existingArticle;
    } else {
      throw new RuntimeException("There is no article with provided articleId!");
    }
  }

  public List<SupportArticle> getArticlesBySubcategory(Long subcategoryId) {
    SupportSubcategory existingSubcategory = supportSubcategoryRepository.findById(subcategoryId).orElse(null);
    if (Objects.nonNull(existingSubcategory)) {
      List<SupportArticle> articles = supportArticleRepository.findBySubcategory(existingSubcategory);
      return articles;
    } else {
      throw new RuntimeException("There is no subcategory with provided categoryId!");
    }
  }

  public SupportArticle editArticle(SupportArticleUpdateRequestModel supportArticleUpdateRequestModel) {
    SupportArticle existingArticle = supportArticleRepository
        .findById(supportArticleUpdateRequestModel.getId()).orElse(null);
    SupportSubcategory existingSubcategory = supportSubcategoryRepository
        .findById(supportArticleUpdateRequestModel.getSubcategoryId()).orElse(null);
    if (Objects.nonNull(existingArticle)) {
      if (Objects.nonNull(existingSubcategory)) {
        existingArticle.setSubcategory(existingSubcategory);
        existingArticle.setTitle(supportArticleUpdateRequestModel.getTitle());
        existingArticle.setContent(supportArticleUpdateRequestModel.getContent());
        supportArticleRepository.save(existingArticle);
        return existingArticle;
      } else {
        throw new RuntimeException("There is no subcategory with provided subcategoryId!");
      }
    } else {
      throw new RuntimeException("There is no article with provided id!");
    }
  }

  public String deleteArticle(Long articleId) {
    SupportArticle existingArticle = supportArticleRepository
        .findById(articleId).orElse(null);
    if (Objects.nonNull(existingArticle)) {
      supportArticleRepository.delete(existingArticle);
      return "Article deleted!";
    } else {
      throw new RuntimeException("There is no article with provided id!");
    }
  }
}
