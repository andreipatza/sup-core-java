package com.sup.core.models.slot;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlotUpdateRequestModel {
  Long id;
  Long lockerId;
  Integer identificationNumber;
  String status;
  Boolean isActive;
}
