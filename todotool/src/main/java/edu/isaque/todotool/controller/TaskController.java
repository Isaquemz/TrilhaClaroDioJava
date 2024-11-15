package edu.isaque.todotool.controller;

import edu.isaque.todotool.dto.task.TaskRegisterRequestDTO;
import edu.isaque.todotool.dto.task.TaskResponseDTO;
import edu.isaque.todotool.dto.user.UserProfileDTO;
import edu.isaque.todotool.service.TaskService;
import edu.isaque.todotool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<TaskResponseDTO>> findAll() {
        UserProfileDTO userProfileDTO = userService.authenticatedUserProfile();
        List<TaskResponseDTO> tasks = taskService.findAll(userProfileDTO);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id) {
        UserProfileDTO userProfileDTO = userService.authenticatedUserProfile();
        TaskResponseDTO task = taskService.findById(userProfileDTO, id);
        return ResponseEntity.ok().body(task);
    }

    @PostMapping("")
    public ResponseEntity<TaskResponseDTO> save(@RequestBody TaskRegisterRequestDTO taskRegisterRequestDTO) {
        UserProfileDTO userProfileDTO = userService.authenticatedUserProfile();
        TaskResponseDTO taskResponseDTO = taskService.save(userProfileDTO, taskRegisterRequestDTO);
        return ResponseEntity.ok().body(taskResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody TaskRegisterRequestDTO taskRegisterRequestDTO
    ) {
        UserProfileDTO userProfileDTO = userService.authenticatedUserProfile();
        taskService.update(id, userProfileDTO, taskRegisterRequestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        UserProfileDTO userProfileDTO = userService.authenticatedUserProfile();
        taskService.delete(userProfileDTO, id);
        return ResponseEntity.ok().body(null);
    }

}
