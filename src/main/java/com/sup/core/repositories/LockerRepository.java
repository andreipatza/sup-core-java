package com.sup.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sup.core.entities.Locker;

public interface LockerRepository extends JpaRepository<Locker, Long> {
  List<Locker> findByIsActive(Boolean isActive);
}
