package com.sup.core.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sup.core.models.locker.LockerRequestModel;
import com.sup.core.models.locker.LockerUpdateRequestModel;
import com.sup.core.services.LockerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/locker")
public class LockerController {

  private final LockerService lockerService;

  // <======= LOCKER RELATED =======>

  @PostMapping("/create-locker")
  public ResponseEntity<?> createLocker(@RequestBody LockerRequestModel lockerRequestModel) {
    return ResponseEntity.ok(lockerService.createLocker(lockerRequestModel));
  }

  @GetMapping("/get-locker")
  public ResponseEntity<?> getLocker(@RequestParam Long lockerId) {
    return ResponseEntity.ok(lockerService.getLocker(lockerId));
  }

  @GetMapping("/get-all-lockers")
  public ResponseEntity<?> getAllLockers() {
    return ResponseEntity.ok(lockerService.getAllLockers());
  }

  @PutMapping("/edit-locker")
  public ResponseEntity<?> editLocker(@RequestBody LockerUpdateRequestModel lockerUpdateRequestModel) {
    return ResponseEntity.ok(lockerService.editLocker(lockerUpdateRequestModel));
  }

  @PutMapping("/activate-locker")
  public ResponseEntity<?> activateLocker(@RequestParam Long lockerId) {
    return ResponseEntity.ok(lockerService.activateLocker(lockerId));
  }

  @PutMapping("/deactivate-locker")
  public ResponseEntity<?> deactivateLocker(@RequestParam Long lockerId) {
    return ResponseEntity.ok(lockerService.deactivateLocker(lockerId));
  }

}
