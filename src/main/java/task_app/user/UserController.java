package task_app.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import task_app.user.dto.UserRequest;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping("")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> result = service.allUsers();
    return ResponseEntity.ok(result);
  }

  @GetMapping("/{id}")
  public Optional<User> getUserById(@PathVariable UUID id) {
    Optional<User> result = service.findUserById(id);
    return result;
  }

  @PostMapping("/")
  public ResponseEntity<String> postUser(@RequestBody UserRequest request) {
    String result = service.create(request.name, request.email, request.password, request.birthDate);
    return ResponseEntity.ok(result);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> putUser(@PathVariable UUID id, @RequestBody UserRequest request) {
    String result = service.update(id, request.name, request.email, request.password, request.birthDate);
    return ResponseEntity.ok(result);
  }

}
