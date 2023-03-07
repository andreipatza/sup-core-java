package com.sup.core.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sup.core.entities.Logs;
import com.sup.core.entities.UserDetails;
import com.sup.core.models.log.LogIntervalModel;
import com.sup.core.repositories.LogsRepository;
import com.sup.core.repositories.UserDetailsRepository;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LogsService {
    private final ModelMapper modelMapper;
    private final UserDetailsRepository userDetailsRepository;
    private final LogsRepository logsRepository;
}
