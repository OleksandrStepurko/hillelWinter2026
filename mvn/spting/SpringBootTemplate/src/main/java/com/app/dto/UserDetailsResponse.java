package com.app.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsResponse {
    private UUID id;
    private String name;
    private String email;
    private String phone;
}
