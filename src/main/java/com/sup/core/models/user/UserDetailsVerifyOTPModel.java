package com.sup.core.models.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailsVerifyOTPModel {
    String phoneNumber;
    String otp;
}