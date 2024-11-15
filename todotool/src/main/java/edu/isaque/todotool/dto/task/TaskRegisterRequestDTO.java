package edu.isaque.todotool.dto.task;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TaskRegisterRequestDTO {

    private String title;
    private String description;
    private String status;
    private String type;
    private String priority;
    private String location;
    private String category;
    private Long assignedTo;
    private List<Long> tags;

}
