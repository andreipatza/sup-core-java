package com.sup.core.models.locker;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LockerRequestModel {
  String name;
  Long latitude;
  Long longitude;
  int noOfSlots;
  int noOfAvailableSlots;
  int noOfSupBoards;
}
