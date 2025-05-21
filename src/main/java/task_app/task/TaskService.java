package task_app.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private final TaskRepository repository;

  public TaskService(TaskRepository repository) {
    this.repository = repository;
  }

  public List<TaskModel> findAll() {
    return repository.findAll();
  }

  public Optional<TaskModel> findOne(UUID id) {
    return repository.findById(id);
  }

  public void create(String name, Boolean completed, String description, LocalDateTime deadline, Boolean priority) {
    TaskModel task = new TaskModel();
    task.setName(name);
    if (completed != null) {
      task.setCompleted(completed);
    }
    task.setCompleted(false);
    if (deadline != null) {
      task.setDeadline(deadline);
    }
    if (description != null) {
      task.setDescription(description);
    }
    task.setDescription("");
    if (priority != null) {
      task.setPriority(priority);
    }
    task.setPriority(false);
    repository.save(task);
  }

  public String update(UUID id, String name, Boolean completed, String description, LocalDateTime deadline,
      Boolean priority) {
    TaskModel task = new TaskModel();
    this.findOne(id);
    if (id == null) {
      return "error";
    }
    task.setName(name);
    task.setCompleted(completed);
    task.setDescription(description);
    task.setDeadline(deadline);
    task.setPriority(priority);
    repository.save(task);
    return "Atualização feita com sucesso.";
  }

}
