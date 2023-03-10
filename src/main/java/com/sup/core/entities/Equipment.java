package com.sup.core.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sup.core.enums.EquipmentStatus;
import com.sup.core.enums.EquipmentType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Equipment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne
  @JoinColumn(name = "slot_id")
  Slot slot;

  Integer identificationNumber;

  @Enumerated(EnumType.STRING)
  EquipmentType type;

  Boolean isActive;
  @Enumerated(EnumType.STRING)
  EquipmentStatus status;

  Timestamp creationDate;
  Timestamp lastUpdate;
}
