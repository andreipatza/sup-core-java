package com.sup.core.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sup.core.models.locker.EquipmentRequestModel;
import com.sup.core.models.locker.EquipmentUpdateModel;
import com.sup.core.models.locker.LockerRequestModel;
import com.sup.core.models.locker.LockerUpdateRequestModel;
import com.sup.core.models.locker.SlotRequestModel;
import com.sup.core.models.locker.SlotUpdateRequestModel;
import com.sup.core.services.LockerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locker")
public class LockerController {

  private final LockerService lockerService;

  // <======= LOCKER RELATED =======>

  @PostMapping("/locker/create-locker")
  public ResponseEntity<?> createLocker(@RequestBody LockerRequestModel lockerRequestModel) {
    return ResponseEntity.ok(lockerService.createLocker(lockerRequestModel));
  }

  @GetMapping("/locker/get-locker")
  public ResponseEntity<?> getLocker(@RequestParam Long lockerId) {
    return ResponseEntity.ok(lockerService.getLocker(lockerId));
  }

  @GetMapping("/locker/get-all-lockers")
  public ResponseEntity<?> getAllLockers() {
    return ResponseEntity.ok(lockerService.getAllLockers());
  }

  @GetMapping("/locker/get-locker-slots")
  public ResponseEntity<?> getLockerSlots(@RequestParam Long lockerId) {
    return ResponseEntity.ok(lockerService.getLockerSlots(lockerId));
  }

  @PutMapping("/locker/edit-locker")
  public ResponseEntity<?> editLocker(@RequestBody LockerUpdateRequestModel lockerUpdateRequestModel) {
    return ResponseEntity.ok(lockerService.editLocker(lockerUpdateRequestModel));
  }

  @PutMapping("/locker/activate-locker")
  public ResponseEntity<?> activateLocker(@RequestParam Long lockerId) {
    return ResponseEntity.ok(lockerService.activateLocker(lockerId));
  }

  @DeleteMapping("/locker/delete-locker")
  public ResponseEntity<?> deactivateLocker(@RequestParam Long lockerId) {
    return ResponseEntity.ok(lockerService.deactivateLocker(lockerId));
  }

  // <======= SLOT RELATED =======>

  @PostMapping("/slot/create-slot")
  public ResponseEntity<?> createSlot(@RequestBody SlotRequestModel slotRequestModel) {
    return ResponseEntity.ok(lockerService.createSlot(slotRequestModel));
  }

  @GetMapping("/slot/get-slot")
  public ResponseEntity<?> getSlotEquipments(@RequestParam Long slotId) {
    return ResponseEntity.ok(lockerService.getSlotEquipments(slotId));
  }

  @GetMapping("/slot/get-slot-equipments")
  public ResponseEntity<?> getSlot(@RequestParam Long slotId) {
    return ResponseEntity.ok(lockerService.getSlot(slotId));
  }

  @PutMapping("/slot/edit-slot")
  public ResponseEntity<?> editSlot(@RequestBody SlotUpdateRequestModel slotUpdateRequestModel) {
    return ResponseEntity.ok(lockerService.editSlot(slotUpdateRequestModel));
  }

  @DeleteMapping("/slot/delete-slot")
  public ResponseEntity<?> deactivateSlot(@RequestParam Long slotId) {
    return ResponseEntity.ok(lockerService.deactivateSlot(slotId));
  }

  @PutMapping("/slot/activate-slot")
  public ResponseEntity<?> activateSlot(@RequestParam Long slotId) {
    return ResponseEntity.ok(lockerService.activateSlot(slotId));
  }

  // <======= EQUIPMENT RELATED =======>

  @PostMapping("/equipment/create-equipment")
  public ResponseEntity<?> createEquipment(@RequestBody EquipmentRequestModel equipmentRequestModel) {
    return ResponseEntity.ok(lockerService.createEquipment(equipmentRequestModel));
  }

  @GetMapping("/equipment/get-equipment")
  public ResponseEntity<?> getEquipment(@RequestParam Long equipmentId) {
    return ResponseEntity.ok(lockerService.getEquipment(equipmentId));
  }

  @PutMapping("/equipment/edit-equipment")
  public ResponseEntity<?> editEquipment(@RequestBody EquipmentUpdateModel equipmentUpdateModel) {
    return ResponseEntity.ok(lockerService.editEquipment(equipmentUpdateModel));
  }

  @DeleteMapping("/equipment/delete-equipment")
  public ResponseEntity<?> deactivateEquipment(@RequestParam Long equipmentId) {
    return ResponseEntity.ok(lockerService.deactivateEquipment(equipmentId));
  }

  @PutMapping("/equipment/activate-equipment")
  public ResponseEntity<?> activateEquipment(@RequestParam Long equipmentId) {
    return ResponseEntity.ok(lockerService.activateEquipment(equipmentId));
  }

}
