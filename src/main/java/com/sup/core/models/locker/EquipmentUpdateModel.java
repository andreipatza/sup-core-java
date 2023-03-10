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
public class EquipmentUpdateModel {
  Long id;
  Long slotId;
  Integer identificationNumber;
  String type;
  Boolean isActive;
  String status;
}
