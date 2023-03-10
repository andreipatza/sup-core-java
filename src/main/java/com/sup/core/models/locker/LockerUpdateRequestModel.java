package com.sup.core.models.locker;

import java.time.LocalTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LockerUpdateRequestModel {
  Long id;
  String name;
  Long latitude;
  Long longitude;
  int noOfSlots;
  int noOfAvailableSlots;
  int noOfSupBoards;
  int noOfAvailableSupBoards;
  String status;
  LocalTime startHour;
  LocalTime endHour;
  Boolean isActive;
}
