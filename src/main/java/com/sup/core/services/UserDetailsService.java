package com.sup.core.services;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sup.core.entities.UserDetails;
import com.sup.core.enums.UserStatus;
import com.sup.core.models.user.UserDetailsRequestModel;
import com.sup.core.models.user.UserDetailsResponseModel;
import com.sup.core.models.user.UserDetailsUpdateRequestModel;
import com.sup.core.models.user.UserDetailsUpdateResponseModel;
import com.sup.core.repositories.UserDetailsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserDetailsService {

    private final ModelMapper modelMapper;
    private final UserDetailsRepository userDetailsRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsResponseModel createUser(UserDetailsRequestModel userDetailsRequestModel) {
        UserDetails existingUser = userDetailsRepository.findByUsername(userDetailsRequestModel.getPhoneNumber())
                .orElse(null);
        if (Objects.isNull(existingUser)) {
            UserDetails newUser = new UserDetails();
            newUser.setUsername(userDetailsRequestModel.getPhoneNumber());
            newUser.setUserStatus(UserStatus.INACTIVE);
            newUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            newUser.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            userDetailsRepository.save(newUser);
            return modelMapper.map(newUser, UserDetailsResponseModel.class);
        } else {
            throw new RuntimeException("Phone number already registered!");
        }
    }

    public UserDetailsUpdateResponseModel updateUser(UserDetailsUpdateRequestModel userDetailsUpdateRequestModel,
            String username) throws Exception {
        UserDetails existingUser = userDetailsRepository.findByUsername(username)
                .orElse(null);
        if (Objects.nonNull(existingUser)) {
            existingUser.setFullName(userDetailsUpdateRequestModel.getFullName());
            existingUser.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            userDetailsRepository.save(existingUser);
            return modelMapper.map(existingUser, UserDetailsUpdateResponseModel.class);
        } else {
            throw new Exception("User not found");
        }
    }

    public String generateOTP(Long userId) throws Exception {
        UserDetails existingUser = userDetailsRepository.findById(userId)
                .orElse(null);
        if (Objects.nonNull(existingUser)) {
            existingUser.setPassword(bCryptPasswordEncoder.encode("123456"));
            existingUser.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            userDetailsRepository.save(existingUser);

            return "Verification code was generated!";
        } else {
            throw new Exception("User not found");
        }
    }

    public String verifyOTP(Long userId, String otp) throws Exception {
        UserDetails existingUser = userDetailsRepository.findById(userId)
                .orElse(null);
        if (Objects.nonNull(existingUser)) {
            if (!bCryptPasswordEncoder.matches(otp, existingUser.getPassword())) {
                throw new Exception("Verification code is invalid!");
            } else {
                return "Verification code is valid!";
            }
        } else {
            throw new Exception("User not found");
        }
    }

}
