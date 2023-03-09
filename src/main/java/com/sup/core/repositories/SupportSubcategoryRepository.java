package com.sup.core.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sup.core.entities.SupportCategory;
import com.sup.core.entities.SupportSubcategory;

public interface SupportSubcategoryRepository extends JpaRepository<SupportSubcategory, Long> {

  Optional<SupportSubcategory> findByName(String name);

  List<SupportSubcategory> findByCategory(SupportCategory category);
}
