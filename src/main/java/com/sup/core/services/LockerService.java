package com.sup.core.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.apache.commons.collections4.TrieUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sup.core.entities.Locker;
import com.sup.core.entities.Slot;
import com.sup.core.models.locker.LockerRequestModel;
import com.sup.core.models.locker.LockerUpdateRequestModel;
import com.sup.core.models.slot.SlotRequestModel;
import com.sup.core.models.slot.SlotUpdateRequestModel;
import com.sup.core.repositories.EquipmentRepository;
import com.sup.core.repositories.LockerRepository;
import com.sup.core.repositories.LockerSlotRepository;
import com.sup.core.repositories.SlotEquipmentRepository;
import com.sup.core.repositories.SlotRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LockerService {

  private final LockerRepository lockerRepository;
  private final SlotRepository slotRepository;
  private final LockerSlotRepository lockerSlotRepository;
  private final EquipmentRepository equipmentRepository;
  private final SlotEquipmentRepository slotEquipmentRepository;

  private final ModelMapper modelMapper;

  // <======= LOCKER RELATED =======>

  public Locker createLocker(LockerRequestModel lockerRequestModel) {
    Locker newLocker = modelMapper.map(lockerRequestModel, Locker.class);
    newLocker.setCreationDate(new Timestamp(System.currentTimeMillis()));
    newLocker.setLastUpdate(new Timestamp(System.currentTimeMillis()));
    newLocker = lockerRepository.save(newLocker);
    return newLocker;
  }

  public Locker getLocker(Long lockerId) {
    Locker locker = lockerRepository.findById(lockerId).orElse(null);
    if (Objects.nonNull(locker)) {
      return locker;
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

  public List<Locker> getAllLockers() {
    List<Locker> lockers = lockerRepository.findAll();
    return lockers;
  }

  public Locker editLocker(LockerUpdateRequestModel lockerUpdateRequestModel) {
    Locker existingLocker = lockerRepository.findById(lockerUpdateRequestModel.getId()).orElse(null);
    if (Objects.nonNull(existingLocker)) {
      var locker = modelMapper.map(lockerUpdateRequestModel, Locker.class);
      locker.setLastUpdate(new Timestamp(System.currentTimeMillis()));
      locker = lockerRepository.save(locker);
      return locker;
    } else {
      throw new RuntimeException("There is no locker with provided id!");
    }
  }

  public String activateLocker(Long lockerId) {
    Locker locker = lockerRepository.findById(lockerId).orElse(null);
    if (Objects.nonNull(locker)) {
      locker.setIsActive(true);
      locker = lockerRepository.save(locker);
      return "Locker is now active!";
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

  public String deactivateLocker(Long lockerId) {
    Locker existingLocker = lockerRepository.findById(lockerId).orElse(null);
    if (Objects.nonNull(existingLocker)) {
      existingLocker.setIsActive(false);
      existingLocker = lockerRepository.save(existingLocker);
      return "Locker is now inactive!";
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

  // <======= SLOT RELATED =======>

  public Slot createSlot(SlotRequestModel slotRequestModel) {
    Locker existingLocker = lockerRepository.findById(slotRequestModel.getLockerId()).orElse(null);
    if (Objects.nonNull(existingLocker)) {
      Slot newSlot = modelMapper.map(slotRequestModel, Slot.class);
      newSlot.setCreationDate(new Timestamp(System.currentTimeMillis()));
      newSlot.setLastUpdate(new Timestamp(System.currentTimeMillis()));
      return newSlot;
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

  public Slot getSlot(Long slotId) {
    Slot newSlot = slotRepository.findById(slotId).orElse(null);
    if (Objects.nonNull(newSlot)) {
      return newSlot;
    } else {
      throw new RuntimeException("There is no slot with provided slotId!");
    }
  }

  public List<Slot> getLockerSlots(Long lockerId) {
    Locker existingLocker = lockerRepository.findById(lockerId).orElse(null);
    if (Objects.nonNull(existingLocker)) {
      List<Slot> lockerSlots = slotRepository.findByLocker(existingLocker);
      return lockerSlots;
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

  public Slot editSlot(SlotUpdateRequestModel slotUpdateRequestModel) {
    Locker existingLocker = lockerRepository.findById(slotUpdateRequestModel.getLockerId()).orElse(null);
    Slot existingSlot = slotRepository.findById(slotUpdateRequestModel.getId()).orElse(null);
    if (Objects.nonNull(existingLocker)) {
      if (Objects.nonNull(existingSlot)) {
        var updatedSlot = modelMapper.map(slotUpdateRequestModel, Slot.class);
        updatedSlot.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        updatedSlot = slotRepository.save(updatedSlot);
        return updatedSlot;
      } else {
        throw new RuntimeException("There is no slot with provided slotId!");
      }
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

  public String activateSlot(Long slotId) {
    Slot existingSlot = slotRepository.findById(slotId).orElse(null);
    if (Objects.nonNull(existingSlot)) {
      existingSlot.setIsActive(true);
      existingSlot = slotRepository.save(existingSlot);
      return "Slot is now active!";
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

  public String deactivateSlot(Long slotId) {
    Slot existingSlot = slotRepository.findById(slotId).orElse(null);
    if (Objects.nonNull(existingSlot)) {
      existingSlot.setIsActive(false);
      existingSlot = slotRepository.save(existingSlot);
      return "Slot is now inactive!";
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

}
