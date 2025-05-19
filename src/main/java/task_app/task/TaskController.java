package task_app.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import task_app.task.Dto.CreateTaskRequest;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @GetMapping()
  public List<TaskModel> getAll() {
    return service.findAll();
  }

  @GetMapping("/id")
  public Optional<TaskModel> getOne(@RequestParam UUID id) {
    return service.findOne(id);
  }

  @PostMapping()
  public void createTask(@RequestBody CreateTaskRequest request) {
    service.create(request.name, request.completed, request.description, request.deadline, request.priority);
  }

}
