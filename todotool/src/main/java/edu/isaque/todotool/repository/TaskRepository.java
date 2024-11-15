package edu.isaque.todotool.repository;

import edu.isaque.todotool.model.Task;
import edu.isaque.todotool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAssignedTo(User user);

    Optional<Task> findByAssignedToAndId(User user, Long id);

}
