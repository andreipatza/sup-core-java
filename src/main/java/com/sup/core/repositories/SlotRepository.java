package com.sup.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sup.core.entities.Locker;
import com.sup.core.entities.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long> {
  List<Slot> findByLocker(Locker locker);
}
