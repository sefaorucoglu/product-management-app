package com.example.ftteknoloji.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
}
