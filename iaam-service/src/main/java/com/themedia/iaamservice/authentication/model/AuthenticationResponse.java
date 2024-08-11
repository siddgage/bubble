package com.themedia.iaamservice.authentication.model;

import com.themedia.iaamservice.common.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {

    private String token;

    @Enumerated(EnumType.STRING)
    private Role role;
}
