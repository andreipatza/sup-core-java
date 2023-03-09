package com.sup.core.restcontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sup.core.models.user.UserDetailsGenerateOTPModel;
import com.sup.core.models.user.UserDetailsRequestModel;
import com.sup.core.models.user.UserDetailsUpdateRequestModel;
import com.sup.core.models.user.UserDetailsVerifyOTPModel;
import com.sup.core.services.UserDetailsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) {
        return ResponseEntity.ok(userDetailsService.createUser(userDetailsRequestModel));
    }

    @PostMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UserDetailsUpdateRequestModel userDetailsUpdateRequestModel)
            throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = (User) principal;
        return ResponseEntity.ok(userDetailsService.updateUser(userDetailsUpdateRequestModel, user.getUsername()));
    }

    @RequestMapping(value = "/generate-otp", method = RequestMethod.POST)
    public ResponseEntity<?> generateOTP(@RequestBody UserDetailsGenerateOTPModel userDetailsGenerateOTPModel)
            throws Exception {
        return ResponseEntity.ok(userDetailsService.generateOTP(userDetailsGenerateOTPModel));
    }

    @RequestMapping(value = "/verify-otp", method = RequestMethod.POST)
    public ResponseEntity<?> verifyOTP(@RequestBody UserDetailsVerifyOTPModel userDetailsVerifyOTPModel)
            throws Exception {
        return ResponseEntity.ok(userDetailsService.verifyOTP(userDetailsVerifyOTPModel));
    }

    @RequestMapping(value = "/verify-account", method = RequestMethod.POST)
    public ResponseEntity<?> verifyAccount(@RequestBody UserDetailsVerifyOTPModel userDetailsVerifyOTPModel)
            throws Exception {
        return ResponseEntity.ok(userDetailsService.verifyAccount(userDetailsVerifyOTPModel));
    }
}
