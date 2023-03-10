package com.sup.core.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sup.core.entities.Locker;
import com.sup.core.models.locker.LockerRequestModel;
import com.sup.core.models.locker.LockerUpdateRequestModel;
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
    Locker locker = modelMapper.map(lockerRequestModel, Locker.class);
    locker.setCreationDate(new Timestamp(System.currentTimeMillis()));
    locker.setLastUpdate(new Timestamp(System.currentTimeMillis()));
    locker = lockerRepository.save(locker);
    return locker;
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
    Locker locker = modelMapper.map(lockerUpdateRequestModel, Locker.class);
    locker.setLastUpdate(new Timestamp(System.currentTimeMillis()));
    locker = lockerRepository.save(locker);
    return locker;
  }

  public String activateLocker(Long lockerId) {
    Locker locker = lockerRepository.findById(lockerId).orElse(null);
    if (Objects.nonNull(locker)) {
      locker.setIsActive(true);
      locker = lockerRepository.save(locker);
      return "Locker is now inactive!";
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

  public String deactivateLocker(Long lockerId) {
    Locker locker = lockerRepository.findById(lockerId).orElse(null);
    if (Objects.nonNull(locker)) {
      locker.setIsActive(false);
      locker = lockerRepository.save(locker);
      return "Locker is now inactive!";
    } else {
      throw new RuntimeException("There is no locker with provided lockerId!");
    }
  }

}
