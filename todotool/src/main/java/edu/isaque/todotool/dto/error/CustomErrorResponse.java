package edu.isaque.todotool.dto.error;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CustomErrorResponse {

    private Instant timestamp;
    private String error;
    private String path;
    private Integer status;

}
