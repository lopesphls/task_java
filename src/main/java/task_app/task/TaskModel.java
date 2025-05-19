package task_app.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class TaskModel {
  @Id
  private UUID id;
  private String name;
  private Boolean completed;
  @Column(length = 500)
  private String description;
  private LocalDateTime deadline;
  private Boolean priority;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public TaskModel() {
  }

  public TaskModel(String name) {
    this.name = name;
  }

  public TaskModel(UUID id, String name, Boolean completed, String description, LocalDateTime deadline,
      Boolean priority) {
    this.id = id;
    this.name = name;
    this.completed = completed;
    this.description = description;
    this.deadline = deadline;
    this.priority = priority;
  }

  @PrePersist
  public void prePersist() {
    if (id == null)
      id = UUID.randomUUID();
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Boolean getCompleted() {
    return completed;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getDeadline() {
    return deadline;
  }

  public Boolean getPriority() {
    return priority;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDeadline(LocalDateTime deadline) {
    this.deadline = deadline;
  }

  public void setPriority(Boolean priority) {
    this.priority = priority;
  }

}
