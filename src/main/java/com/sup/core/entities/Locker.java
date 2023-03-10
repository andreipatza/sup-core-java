package com.sup.core.entities;

import java.sql.Timestamp;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sup.core.enums.LockerStatus;

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
public class Locker {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String name;

  Long latitude;
  Long longitude;

  int noOfSlots;
  int noOfAvailableSlots;
  int noOfSupBoards;
  int noOfAvailableSupBoards;

  LocalTime startHour;
  LocalTime endHour;

  @Enumerated(EnumType.STRING)
  LockerStatus status;
  Boolean isActive;

  Timestamp creationDate;
  Timestamp lastUpdate;
}
