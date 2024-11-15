package edu.isaque.todotool.dto.task;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime dueDate;
    private LocalDateTime lastModifiedDate;
    private Long assignedTo;
    private Long createdBy;
    private List<Long> tags;

}
