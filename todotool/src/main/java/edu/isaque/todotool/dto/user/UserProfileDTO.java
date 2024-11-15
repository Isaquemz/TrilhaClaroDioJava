package edu.isaque.todotool.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserProfileDTO {
    private Long id;
    private String name;
    private String email;
}
