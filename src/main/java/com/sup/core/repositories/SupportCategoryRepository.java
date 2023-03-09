package com.sup.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sup.core.entities.SupportCategory;

public interface SupportCategoryRepository extends JpaRepository<SupportCategory, Long> {

  Optional<SupportCategory> findByName(String name);
}
