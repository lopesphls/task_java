package task_app.task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import task_app.task.Dto.TaskRequest;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @GetMapping()
  public List<Task> getAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Task> getOne(@PathVariable UUID id) {
    return service.findOne(id);
  }

  @PostMapping()
  public void createTask(@RequestBody TaskRequest request) {
    service.create(request.name, request.completed, request.description, request.deadline, request.priority);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> putTask(@PathVariable UUID id, @RequestBody TaskRequest request) {
    String result = service.update(id, request.name, request.completed, request.description, request.deadline,
        request.priority);
    return ResponseEntity.ok(result);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteTask(@PathVariable UUID id) {
    String result = service.deleteTask(id);
    return ResponseEntity.ok(result);
  }

}
