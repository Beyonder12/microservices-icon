package com.beyonder.gatewayservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String role;
}