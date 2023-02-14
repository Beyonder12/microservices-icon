package com.beyonder.authenticationservice.service;

import com.beyonder.authenticationservice.dto.UserDTO;
import org.springframework.security.core.Authentication;

public interface TokenService {
    String generatedToken(Authentication authentication);
    UserDTO decodeToken(String token);
    void addUser(UserDTO userDTO);
}
