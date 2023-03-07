package com.sup.core.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.sup.core.entities.UserDetails;
import com.sup.core.enums.Role;
import com.sup.core.enums.UserStatus;
import com.sup.core.exceptions.SpeechPlatformException;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

        Optional<UserDetails> findByUsername(String username);
}
