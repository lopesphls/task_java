package task_app.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public ResponseEntity<List<UserModel>> getAllUsers() {
    List<UserModel> result = service.allUsers();
    return ResponseEntity.ok(result);

  }

  @PostMapping("/")
  public ResponseEntity<String> createUser(@RequestBody UserRequest request) {
    String result = service.create(request.name, request.email, request.password, request.birthDate);
    return ResponseEntity.ok(result);
  }

}
