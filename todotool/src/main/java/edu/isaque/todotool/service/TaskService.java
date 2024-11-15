package edu.isaque.todotool.service;

import edu.isaque.todotool.dto.task.TaskRegisterRequestDTO;
import edu.isaque.todotool.dto.task.TaskResponseDTO;
import edu.isaque.todotool.dto.user.UserProfileDTO;
import edu.isaque.todotool.exception.TaskNotFoundException;
import edu.isaque.todotool.mapper.TaskMapper;
import edu.isaque.todotool.model.Task;
import edu.isaque.todotool.model.User;
import edu.isaque.todotool.repository.TaskRepository;
import edu.isaque.todotool.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    private User findUser(UserProfileDTO userProfileDTO) {
        Optional<User> user = userRepository.findById(userProfileDTO.getId());
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }

    public List<TaskResponseDTO> findAll(UserProfileDTO userProfileDTO) {
        User user = findUser(userProfileDTO);
        return taskRepository.findByAssignedTo(user)
                .stream()
                .map(taskMapper::toTaskResponseDTO)
                .collect(Collectors.toList());
    }

    public TaskResponseDTO findById(UserProfileDTO userProfileDTO, Long id) {
        User user = findUser(userProfileDTO);
        return taskRepository.findByAssignedToAndId(user, id)
            .map(taskMapper::toTaskResponseDTO)
            .orElseThrow(() -> new TaskNotFoundException("Task not found"));
    }

    public TaskResponseDTO save(UserProfileDTO userProfileDTO, TaskRegisterRequestDTO registerRequestDTO) {
        User user = findUser(userProfileDTO);
        Task task = taskMapper.toTask(registerRequestDTO);
        task.setCreatedBy(user);
        Task taskSaved = taskRepository.save(task);
        return taskMapper.toTaskResponseDTO(taskSaved);
    }

    public void update(Long id, UserProfileDTO userProfileDTO, TaskRegisterRequestDTO registerRequestDTO) {
        User user = findUser(userProfileDTO);
        Task currentTaskVersion = taskRepository.findByAssignedToAndId(user, id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        Task updatedTask = taskMapper.toTask(registerRequestDTO);
        Task taskToSave = taskMapper.updateTask(updatedTask, currentTaskVersion);
        taskRepository.save(taskToSave);
    }

    public void delete(UserProfileDTO userProfileDTO, Long id) {
        User user = findUser(userProfileDTO);
        Task task = taskRepository.findByAssignedToAndId(user, id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));
        taskRepository.delete(task);
    }

}
