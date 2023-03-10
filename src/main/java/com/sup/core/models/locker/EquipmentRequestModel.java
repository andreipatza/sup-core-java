package com.sup.core.models.locker;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.print.DocFlavor.STRING;

import com.sup.core.enums.EquipmentType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipmentRequestModel {
  Long slotId;
  Integer identificationNumber;

  @Enumerated(EnumType.STRING)
  EquipmentType type;
}
