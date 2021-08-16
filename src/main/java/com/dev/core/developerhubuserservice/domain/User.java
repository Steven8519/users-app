package com.dev.core.developerhubuserservice.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String username;
    private String displayName;
    private String password;
}
