package com.sup.core.models.user;

import java.sql.Timestamp;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetailsUpdateResponseModel {
    Long id;
    String username;
    String fullName;
    String userStatus;

    Timestamp createdAt;
    Timestamp lastUpdate;

}
