package edu.isaque.todotool.model;

import edu.isaque.todotool.enums.PriorityTask;
import edu.isaque.todotool.enums.StatusTask;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(schema = "public", name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String title;
    String description;

    @Enumerated(EnumType.STRING)
    StatusTask status;

    @Enumerated(EnumType.STRING)
    PriorityTask priority;

    @CreationTimestamp
    LocalDateTime dueDate;

    @CreationTimestamp
    LocalDateTime createdDate;

    @UpdateTimestamp
    LocalDateTime lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "assigned_to")
    User assignedTo;

    @ManyToOne
    @JoinColumn(name = "created_by")
    User createdBy;

    @ManyToMany
    @JoinTable(
        name = "task_tags",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    List<Tag> tags;

    @PrePersist
    public void fixesdueDate() {
        this.createdDate = LocalDateTime.now();
        this.createdDate = this.createdDate.plus(2, ChronoUnit.DAYS);
    }

}
