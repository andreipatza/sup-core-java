package com.sup.core.authentication.controller;

import java.util.Objects;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sup.core.authentication.JwtTokenUtil;
import com.sup.core.authentication.model.JwtRequest;
import com.sup.core.authentication.model.JwtResponse;
import com.sup.core.entities.UserDetails;
import com.sup.core.exceptions.SupCoreException;
import com.sup.core.repositories.UserDetailsRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws AuthenticationException {
        UserDetails userDetails = userDetailsRepository.findByUsername(authenticationRequest.getUsername())
                .orElse(null);

        if (Objects.nonNull(userDetails)) {
            if (!bCryptPasswordEncoder.matches(authenticationRequest.getPassword(), userDetails.getPassword())) {
                throw new SupCoreException(HttpStatus.BAD_REQUEST, "Verification code is invalid!");
            }

            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            final String token = jwtTokenUtil.generateToken(authentication);
            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            throw new SupCoreException(HttpStatus.NOT_FOUND, "User not found!");
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("Successfully logged out.");
    }
}