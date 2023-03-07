package com.sup.core.authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sup.core.entities.UserDetails;
import com.sup.core.enums.Role;
import com.sup.core.enums.UserStatus;
import com.sup.core.repositories.UserDetailsRepository;

@Component
@RequiredArgsConstructor
public class ApplicationEvent {

    private final UserDetailsRepository userDetailsRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationEvent() {

        if (notExists()) {
            var appUser = UserDetails.builder()
                    .username("A-SpeechToTextAdmin")
                    .password("$2a$04$XgKPjglsMc9y6ga60yxvCO2bUlurXNPCuGaI6wEVI3hz9FSoLztJS")
                    .userStatus(UserStatus.ACTIVE)
                    .build();
            userDetailsRepository.save(appUser);
        }

    }

    private boolean notExists() {
        return userDetailsRepository.findByUsername("A-SpeechToTextAdmin").isEmpty();
    }
}
