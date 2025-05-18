package task_app.task;

import java.util.List;

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

}
