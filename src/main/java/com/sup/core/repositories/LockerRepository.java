package com.sup.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sup.core.entities.Locker;

public interface LockerRepository extends JpaRepository<Locker, Long> {

}
