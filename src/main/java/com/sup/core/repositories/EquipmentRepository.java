package com.sup.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sup.core.entities.Equipment;
import com.sup.core.entities.Slot;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
  List<Equipment> findBySlot(Slot slot);
}
