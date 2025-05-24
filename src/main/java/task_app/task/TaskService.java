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

  public List<Task> findAll() {
    return repository.findAll();
  }

  public Optional<Task> findOne(UUID id) {
    return repository.findById(id);
  }

  public void create(String name, Boolean completed, String description, LocalDateTime deadline, Boolean priority) {
    Task task = new Task();
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
    Optional<Task> update = this.findOne(id);
    if (update.isEmpty()) {
      return "Tarefa não encontrada.";
    }
    Task task = update.get();
    task.setName(name);
    task.setCompleted(completed);
    task.setDescription(description);
    task.setDeadline(deadline);
    task.setPriority(priority);
    repository.save(task);
    return "Atualização feita com sucesso.";
  }

  public String deleteTask(UUID id) {
    if (id == null) {
      return "Tarefa não encontrada.";
    }
    repository.deleteById(id);
    return "Tarefa deletada com sucesso";

  }

}
